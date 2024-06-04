package uniesp.pdvfiscal.produtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Produto> create(@RequestBody Produto produto) {

        Produto produtoCreated = service.create(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCreated);
    }

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> findAll() {
        return service.findAll();
    }

    @GetMapping("/findById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Produto> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/findByName/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Produto> findByNome(@PathVariable String nome) {
        return service.findByNome(nome);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

