CREATE TABLE IF NOT EXISTS divida(
  id BIGSERIAL PRIMARY KEY NOT NULL,
  valor_divida NUMERIC(19,2),
  tipo_juros VARCHAR,
  qtde_parcelas INT,
  porcentagem_comissao INT,
  dia_vencimento INT
);