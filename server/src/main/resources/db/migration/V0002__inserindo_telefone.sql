ALTER TABLE IF EXISTS divida
  ADD COLUMN IF NOT EXISTS telefone int,
  DROP COLUMN IF EXISTS dia_vencimento,
  ADD COLUMN IF NOT EXISTS dia_vencimento DATE,
  ADD COLUMN IF NOT EXISTS porcentagem_juros NUMERIC(19,2),
  DROP COLUMN IF EXISTS valor_divida,
  ADD COLUMN IF NOT EXISTS valor_divida NUMERIC(19,2),
  DROP COLUMN IF EXISTS porcentagem_comissao,
  ADD COLUMN IF NOT EXISTS porcentagem_comissao  NUMERIC(19,2);