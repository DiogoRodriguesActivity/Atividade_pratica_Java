```
equals(): compara o conteúdo da string e diferencia maiúsculas de minúsculas.
equalsIgnoreCase(): compara o conteúdo e ignora a diferença entre maiúsculas e minúsculas.

> Resposta do Claude a respeito do porque buscar funcionario não funcionava:
Em strings, o == compara se são o mesmo objeto na memória, não se têm o mesmo texto.
Por isso o somaFinalizados() do seu código antigo era frágil: this.getStatus()== "finalizado"
pode dar certo ou errado dependendo de como a string foi criada (por exemplo,
se vier de um Scanner, quase sempre dá false, mesmo com o texto idêntico).

Outra forma de usar:
```

```python
"finalizado".equalsIgnoreCase(status); // seguro mesmo se status for null
status.equalsIgnoreCase("finalizado"); // quebra se status for null
```
## Estrutura do projeto
 
Todas as classes estão no pacote `pacote`.
 
```
pacote
├── Main.java
├── Clinica.java
├── Veterinario.java
├── Sala.java
├── Procedimento.java
└── Atendimento.java
```
 
## Função de cada classe
 
### `Veterinario`
Representa o profissional da clínica. Guarda nome, CPF, especialidade e telefone. É uma classe de dados: só possui atributos privados, construtor, getters e setters.
 
### `Procedimento`
Representa um serviço oferecido pela clínica (por exemplo, uma consulta). Guarda o nome, o valor e o **tipo de sala exigido** para realizá-lo, que é usado para validar a compatibilidade com a sala.
 
### `Sala`
Representa um local de atendimento. Guarda número, bloco, capacidade, tipo da sala e o **veterinário responsável**. Também armazena em uma lista os atendimentos realizados nela, que formam o histórico da sala. É responsável por:
 
- validar se o procedimento é compatível com o tipo da sala;
- validar se a capacidade não foi excedida (contam apenas os atendimentos não finalizados);
- adicionar atendimentos à própria lista;
- contar os atendimentos em andamento e os finalizados da sala.
### `Atendimento`
Representa uma consulta ou procedimento realizado em um animal. Guarda código, nome do animal, espécie, tutor, data, horário, status e observações. Está associado a uma `Sala` (e, por meio dela, ao `Veterinario`) e a um `Procedimento`. O método `isFinalizado()` informa se o status é "finalizado".
 
### `Clinica`
Classe de **gerenciamento**: armazena os dados em listas (`List`) e controla os cadastros e as buscas. Mantém quatro coleções:
 
- veterinários;
- salas;
- procedimentos;
- atendimentos (histórico geral).
Responsabilidades:
 
- cadastrar veterinários, salas, procedimentos e atendimentos;
- impedir que um veterinário seja associado a mais de uma sala;
- impedir números de sala e códigos de atendimento duplicados;
- buscar veterinário (por CPF), sala (por número), procedimento (por nome) e atendimento (por código).
### `Main`
Classe de **interação com o usuário**. Contém o menu e lê os dados digitados no console. Não guarda dados nem aplica regras: chama a `Clinica` para executar cada operação. Ao iniciar, carrega alguns dados de exemplo para facilitar os testes.
 
## Relacionamentos entre as classes
 
```
Main ──usa──> Clinica ──armazena──> Veterinario, Sala, Procedimento, Atendimento
 
Sala ──tem──> Veterinario       (um veterinário responsável)
Sala ──tem──> Atendimento[]     (histórico de atendimentos da sala)
 
Atendimento ──pertence a──> Sala
Atendimento ──realiza──> Procedimento
```
 
## Regras de negócio
 
- Um veterinário só pode estar associado a **uma** sala.
- Um atendimento só pode ser cadastrado em uma sala cujo tipo seja o exigido pelo procedimento.
- A sala não pode ter mais atendimentos em andamento do que a sua capacidade. Ao finalizar um atendimento, a vaga é liberada, mas ele permanece no histórico.
- Não podem existir duas salas com o mesmo número nem dois atendimentos com o mesmo código.
## Funcionalidades do menu
 
| Opção | Ação |
|---|---|
| 1 | Cadastrar veterinário |
| 2 | Cadastrar sala |
| 3 | Cadastrar procedimento |
| 4 | Cadastrar atendimento |
| 5 | Listar atendimentos (histórico) |
| 6 | Buscar atendimentos por status |
| 7 | Finalizar atendimento |
| 8 | Total de atendimentos finalizados por sala |
| 0 | Sair |
 
## Como executar
 
1. Crie um projeto Java no Eclipse.
2. Crie o pacote `pacote` e adicione as seis classes.
3. Execute a classe `Main` (Run As > Java Application).
