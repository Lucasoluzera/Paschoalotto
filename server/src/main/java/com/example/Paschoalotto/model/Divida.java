package com.example.Paschoalotto.model;

import com.example.Paschoalotto.enums.TipoJuros;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "divida")
@Data
public class Divida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_juros")
    @Enumerated(EnumType.STRING)
    private TipoJuros tipoJuros;

    @Column(name = "qtde_parcelas")
    private int qtdeParcelas;

    @Column(name = "porcentagem_comissao")
    private BigDecimal porcentagemComissao;

    @Column(name = "dia_vencimento")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate diaVencimento;

    @Column(name = "porcentagem_juros")
    private BigDecimal porcentagemJuros;

    @Column(name = "valor_divida")
    private BigDecimal valorDivida;

    @Column(name = "telefone")
    private int telefone;
}
