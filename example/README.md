# Aula 5 (29/02/2024)
## Regex
- \* significa 0 ou mais repetições
- \+ significa 1 ou mais repetições

## Símbolos
- Um símbolo léxico definido implicitamente encontra-se **dentro de pelicas**, não aspas!
- `|` significa "ou". É o operador menos importante do ANTLR4.
- Tokens que são encaminhados para `skip` são reconhecidos mas não passam para a análise sintática.
- Num Integer, deve ser + e não *, já que é má ideia uma palavra vazia ser considerada um `int`.

## Compilar
```bash
antlr4 Expr.g4
javac *.java
```

São gerados alguns ficheiros, tais como:
- `[nome]Parse.java` - Análise sintática
- `[nome]Lexer.java` - Análise léxica
- `[nome]Listener.java` - Implementa um Listener

## Testar
Correr `antlr4-test` para testar a gramática, que aceita a expressões no `stdin`.

| Parâmetro | Significado                       |
|-----------|-----------------------------------|
| `-tokens` | Mostrar a lista de tokens gerados |
| `-gui`    | Mostrar a árvore sintática        |

*Este comando apenas cria a árvore, não cria Visitor e Listener!*

## Listener
Correr `antlr4-listener` para criar um listener, onde se pode efetuar ações a cada vez que se entra ou sai de um determinado token. Com o parâmetro ``

## Visitor
Correr `antlr4-visitor` para criar um visitor. Visita apenas símbolos sintáticos, não léxicos.

## Main
Correr `antlr4-main` gera o método `main` onde tudo começa.

| Parâmetro         | Significado        |
|-------------------|--------------------|
| `-l`, `-listener` | Injeta um Listener |
| `-v`, `-visitor`  | Injeta um Visitor  |

## Build (?)
Correr `antlr4-build` faz tudo e mais não sei o quê.

## Limpar
Correr `antlr4-clean` para apagar tudo menos o código-fonte.