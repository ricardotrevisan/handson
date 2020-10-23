
<h2 align="center">
	Frame REST API baseado na apresentação livre da <a href="http://www.algaworks.com">Algaworks</a>
</h2>


#### Microsserviços (CRUD) -  montado em Java com Spring Tools Suite 4:
  Em rápida exposição de microsserviços para manipulação de informações de Backend - entidade única - o projeto é um template demonstrando ganhos de produtividade promovidos pelo Spring Framework. 
  
  Sinteticamente, o uso da padronização de configurações proposta pelo *Spring Boot* alivia esforços de configuração e consumo de serviços definidos na Arquitetura da Solução. 
  
  Fundado sobre o MAVEN e servido pelos Spring Starters, componentes e módulos são rapidamente inseridos no contexto do projeto, garantindo minima intervenção e anulando  derivação de elementos específicos de cada ambiente ou preferências de Desenvolvimento/or. 
  
  Notavel a decorrente combinação do recurso de metadados - Java Annotations, inserido lá na versão 1.5 - simplificando a alocação de recursos (processo conhecido como Wiring). 
  
  @Resource, @Inject e @Autowired são exemplos (o ultimo adicionado pelo framework Spring), mas os processos de validação de input (@Validate) ou mesmo os de métodos HTTP implementados/disponíveis (@GetMapping, @PostMapping, @PutMapping, @DeleteMapping) são beneficiados pela combinação e rapidamente viabilizados.  
  
  Volume menor de código escrito, forte definição de tipos e responsabilidades, e padronização que acelera a transferencia de conhecimento e adoção de novos integrantes aos times. 
  
Entre as dependênicas mais importantes estão: 
  - Spring Boot 4.0.x + DevTools
  - Flyway DB 6.4.4
  - MySQL 5.7

Embora curl possa viabilizar os testes, utilizamos o Postman como ferramenta para os requests a API.
A configuração está disponivel na estrutura do projeto em resources/requests.


