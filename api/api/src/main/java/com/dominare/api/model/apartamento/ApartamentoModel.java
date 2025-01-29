package com.dominare.api.model.apartamento;
import jakarta.persistence.*;
import lombok.*;

@Entity
// @Embeddable
@Table(name = "apartamentos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class ApartamentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String responsavel;
    private String bloco;
    private String numero;
 
    // @OneToMany(mappedBy = "apartamento", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<PessoaModel> moradores = new ArrayList<>();

    public ApartamentoModel(DadosApartamento dados) {
        this.bloco = dados.bloco();
        this.numero = dados.numero();
        this.responsavel = dados.responsavel();
    }

    
}
