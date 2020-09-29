package com.example.Paschoalotto.dtos;

import com.example.Paschoalotto.enums.TipoJuros;
import com.example.Paschoalotto.model.Divida;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Data
public class DividaDTO {

    private Long id;

    private BigDecimal valorDivida;

    private TipoJuros tipoJuros;

    private int qtdeParcelas;

    private BigDecimal porcentagemComissao;

    private BigDecimal porcentagemJuros;

    private BigDecimal valorComissao;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate diaVencimento;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private List<LocalDate> datasVencimento = new ArrayList<>();

    private List<BigDecimal> parcelas = new ArrayList<>();

    private int telefone;

    public static DividaDTO toDTO(Divida divida) {
        DividaDTO dividaDTO = new DividaDTO();
        dividaDTO.setId(divida.getId());
        dividaDTO.setDiaVencimento(divida.getDiaVencimento());
        dividaDTO.setQtdeParcelas(divida.getQtdeParcelas());
        dividaDTO.setPorcentagemComissao(divida.getPorcentagemComissao());
        dividaDTO.setPorcentagemJuros(divida.getPorcentagemJuros());
        dividaDTO.setTipoJuros(divida.getTipoJuros());
        dividaDTO.setTelefone(divida.getTelefone());
        dividaDTO.setValorDivida(divida.getValorDivida());

        BigDecimal valorTotalJuros = null;

        for (int i = 0; i < dividaDTO.getQtdeParcelas(); i++) {
            LocalDate localDate = dividaDTO.getDiaVencimento();

            if (i > 0)
                 localDate = dividaDTO.getDiaVencimento().plusMonths(i);


            dividaDTO.datasVencimento.add(localDate);
            BigDecimal valorParcela = dividaDTO.valorDivida.divide(BigDecimal.valueOf(dividaDTO.getQtdeParcelas()));

            long dias = ChronoUnit.DAYS.between(localDate, LocalDate.now());

            if(dias < 0){
                dividaDTO.parcelas.add(valorParcela);
                continue;
            }
            if (dividaDTO.getTipoJuros().equals(TipoJuros.SIMPLES)) {
//               M = C + C x n x i
                BigDecimal valorParaSomar = valorParcela.multiply(new BigDecimal(dias));
                valorParaSomar = valorParaSomar.multiply(dividaDTO.porcentagemJuros.divide(BigDecimal.valueOf(100)));
                dividaDTO.parcelas.add(valorParcela.add(valorParaSomar));
                if(valorTotalJuros == null)
                    valorTotalJuros =  valorParcela.add(valorParaSomar);
                else
                    valorTotalJuros =  valorTotalJuros.add(valorParcela.add(valorParaSomar));
            } else {
//                M = C x (1 + i)^n
                BigDecimal valorParaSomar = dividaDTO.porcentagemJuros.add(BigDecimal.valueOf(1)).multiply(BigDecimal.valueOf(dias));
                dividaDTO.parcelas.add(valorParcela.add(valorParaSomar));
                if(valorTotalJuros == null)
                    valorTotalJuros =  valorParcela.add(valorParaSomar);
                else
                    valorTotalJuros =  valorTotalJuros.add(valorParcela.add(valorParaSomar));

            }

        }
        dividaDTO.setValorComissao(valorTotalJuros.multiply(dividaDTO.porcentagemComissao.divide(BigDecimal.valueOf(100))));
        return dividaDTO;
    }

    public static Divida toEntity(DividaDTO dividaDTO){
        Divida divida = new Divida();
        divida.setId(dividaDTO.getId());
        divida.setDiaVencimento(dividaDTO.getDiaVencimento());
        divida.setQtdeParcelas(dividaDTO.getQtdeParcelas());
        divida.setPorcentagemComissao(dividaDTO.getPorcentagemComissao());
        divida.setPorcentagemJuros(dividaDTO.getPorcentagemJuros());
        divida.setTipoJuros(dividaDTO.getTipoJuros());
        divida.setTelefone(dividaDTO.getTelefone());
        divida.setValorDivida(dividaDTO .getValorDivida());


        return divida;
    }
}
