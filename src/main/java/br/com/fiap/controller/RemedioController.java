package br.com.fiap.controller;

import br.com.fiap.model.dto.RemedioDTO;
import br.com.fiap.model.entity.Remedio;
import br.com.fiap.model.repository.RemedioRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/drogaria")
public class RemedioController {

    private final RemedioRepository remedioRepository;

    public RemedioController(RemedioRepository remedioRepository) {
        this.remedioRepository = remedioRepository;
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        return new ModelAndView("formulario");
    }

    @PostMapping
    public ModelAndView cadastrar(@Valid RemedioDTO remedioDTO, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("formulario");   // volta ao formulário mostrando os erros
        }
        remedioRepository.save(new Remedio(remedioDTO));
        return new ModelAndView("redirect:/drogaria");
    }

    @GetMapping
    public ModelAndView consultar() {
        List<Remedio> remedios = remedioRepository.findAll();
        ModelAndView mv = new ModelAndView("remedios");
        mv.addObject("remedios", remedios);
        return mv;
    }

    @GetMapping("/editar/{codigo}")
    public ModelAndView consultarPorCodigo(@PathVariable long codigo) {
        Remedio remedio = remedioRepository.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("formulario");
        mv.addObject("remedio", remedio);
        mv.addObject("acao", "/drogaria/atualizar/" + codigo);
        return mv;
    }

    @GetMapping("/excluir/{codigo}")
    public ModelAndView excluir(@PathVariable long codigo) {
        remedioRepository.deleteById(codigo);
        ModelAndView mv = new ModelAndView("redirect:/drogaria");
        return mv;
    }

    @PostMapping("/atualizar/{codigo}")
    public ModelAndView atualizar(@PathVariable Long codigo, @Valid RemedioDTO remedioDTO, BindingResult result) {
        if (result.hasErrors()){
            return new ModelAndView("redirect:/drogaria");
        }
        Remedio remedio = new Remedio(remedioDTO);
        remedio.setCodigo(codigo);
        remedioRepository.save(remedio);
        ModelAndView mv = new ModelAndView("redirect:/drogaria");
        return mv;

    }
}