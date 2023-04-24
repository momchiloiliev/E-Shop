package mk.ukim.finki.emt.eshop.web.rest;


import mk.ukim.finki.emt.eshop.model.Discount;
import mk.ukim.finki.emt.eshop.model.dto.DiscountDto;
import mk.ukim.finki.emt.eshop.model.exceptions.DiscountNotFoundException;
import mk.ukim.finki.emt.eshop.service.DiscountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/discounts")
public class DiscountRestController {//crud funkcionalnost->create,read,update,delete

    private final DiscountService discountService;

    public DiscountRestController(DiscountService discountService) {
        this.discountService = discountService;
    }

    //Read
    @GetMapping
    public List<Discount> findAll(){
        return this.discountService.findAll();
    }

    @GetMapping("/pagination")
    public Page<Discount> findAllWithPagination(Pageable pageable){
        return this.discountService.findAllWithPagination(pageable);
    }

    //Create
    @PostMapping("/add")
    public ResponseEntity<Discount> save(@RequestBody DiscountDto discountDto){
        return this.discountService.save(discountDto)
                .map(discount -> ResponseEntity.ok().body(discount))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    //Update

    @PutMapping("/edit/{id}")
    public ResponseEntity<Discount> edit(@PathVariable Long id, @RequestBody DiscountDto discountDto){
        return this.discountService.edit(id, discountDto)
                .map(discount -> ResponseEntity.ok().body(discount))
                .orElseGet(()->ResponseEntity.notFound().build());
    }


    //todo: Delete

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        this.discountService.deleteById(id);
        if(this.discountService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/assign/{id}")
    public ResponseEntity<Discount> assignDiscount(@PathVariable Long id, @RequestParam String username){
        return this.discountService.assign(username, id)
                .map(discount -> ResponseEntity.ok().body(discount))
                .orElseGet(()->ResponseEntity.notFound().build());
    }



}
