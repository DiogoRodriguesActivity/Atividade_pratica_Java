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
