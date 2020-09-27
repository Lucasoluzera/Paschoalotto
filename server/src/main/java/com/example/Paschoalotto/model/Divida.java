package com.example.Paschoalotto.model;

import com.example.Paschoalotto.enums.TipoJuros;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "divida")
@Data
public class Divida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "valor_divida")
    private BigDecimal valorDivida;

    @Column(name = "tipo_juros")
    @Enumerated(EnumType.STRING)
    private TipoJuros tipoJuros;

    @Column(name = "qtde_parcelas")
    private int qtdeParcelas;

    @Column(name = "porcentagem_comissao")
    private int porcentagemComissao;

    @Column(name = "dia_vencimento")
    private int diaVencimento;
}
