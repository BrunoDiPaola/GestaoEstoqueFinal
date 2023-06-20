package br.com.bruno.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import java.lang.System.Logger.Level;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 1, message = "O nome do material precisa ser válido.")
    private String nome;
    private BigInteger lote;

    private float preco;
    private Date validade = new Date();;
    private Integer quantidade_total;
    
    @Override
    public String toString() {
        return nome;
    }
    
     public String getValidadeFormatada() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(validade);
    }
    
     public String getValidade() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(validade);
    }

    public void setValidade(String validade) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
        Date data = null;
        try {
            data = formato.parse(validade);
        } catch (ParseException ex) {
            //Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.validade = data;
    }
    
}

