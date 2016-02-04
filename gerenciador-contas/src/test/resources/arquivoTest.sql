insert into conta (id,agencia, banco, numero, titular) values (1,'043','Caixa','54321','Pedro Lira');
insert into conta (id,agencia, banco, numero, titular) values (52,'043','Banco do Brasil','54321','Raphael Gamarra');
insert into conta (id,agencia, banco, numero, titular) values (102,'043','Itau','54321','Thayna Soares');
insert into conta (id,agencia, banco, numero, titular) values (152,'043','Bradesco','54321','Débora Silva');
insert into conta (id,agencia, banco, numero, titular) values (202,'043','BRB','54321','Heloisa Soares');

insert into movimentacao (data,descricao,tipoMovimentacao, valor, conta_id) values('2016-02-04','Conta de Luz','SAIDA','123.90',1);
insert into movimentacao (data,descricao,tipoMovimentacao, valor, conta_id) values('2016-02-04','Conta de Agua','SAIDA','23.90',52);
insert into movimentacao (data,descricao,tipoMovimentacao, valor, conta_id) values('2016-02-04','Conta de Telefone','SAIDA','230.90',102);
insert into movimentacao (data,descricao,tipoMovimentacao, valor, conta_id) values('2016-02-04','Materias Escolares','SAIDA','230.90',152);
insert into movimentacao (data,descricao,tipoMovimentacao, valor, conta_id) values('2016-02-04','Fraldas','SAIDA','50.90',202);
