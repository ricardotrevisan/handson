
<h2 align="center">
	Frame REST API baseado na apresentação livre da <a href="http://www.algaworks.com">Algaworks</a>
</h2>

## CRUD exposto como Microsserviços, montado em Java com Spring Tools Suite 4

## Estrutura:
  Rápida exposição de microserviços para manipulação de informações sobre a entidade Cliente (unica).
  Demonstra ganhos de produtividade promovidos pelo Spring Framework. 
  Sinteticamente, o uso da padronização de configurações proposta pelo *Spring Boot* nos garante a minima atuação na composição de serviços e dependências necessárias a aplicaçõ. E a decorrente combinação do recurso de metadados - Java Annotations (inserido desde a versão 1.5) - simplificando a alocação de recursos com o Wiring. 
  @Resource, @Inject e @Autowired são exemplos (o ultimo adicionado pelo framework Spring), mas os processos de validação de input (@Validate) ou mesmo os de métodos HTTP implementados/disponíveis (@GetMapping, @PostMapping, @PutMapping, @DeleteMapping) são beneficiados pela combinação. 
  Volume menor de código escrito, forte definição de tipos e responsabilidades, e padronização que acelera a transferencia de conhecimento e adoção de novos integrantes aos times. 
  
Entre as dependênicas mais importantes estão: 
  - Spring Boot 4.0.x
  - Flyway DB 6.4.4
  - MySQL 5.7

Embora curl possa viabilizar os testes, utilizamos o Postman como ferramenta para os requests à API.
A configuração está disponivel na estrutura do projeto em resources/requests.


