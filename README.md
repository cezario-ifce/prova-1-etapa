# 🎬 Prova de Desenvolvimento Web em Java

## Tema: Catálogo de Filmes

Você irá implementar um pequeno sistema para gerenciar um catálogo de filmes utilizando **Spring Boot + Spring Data JPA + Banco H2**.

O projeto base já contém:

- `pom.xml` — dependências configuradas
- `application.properties` — banco H2 em memória já configurado
- `schema.sql` — estrutura da tabela `filme`
- `data.sql` — dados de exemplo
- `FilmeApplication.java` — classe principal da aplicação

Você deve preencher os pacotes `entity`, `repository` e `service`.

> 💡 Para testar, basta rodar a classe `FilmeApplication` e acessar o console do H2 em `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:filmesdb`, usuário: `sa`, sem senha).

---

## 🟦 Questão 1 — Clonar o projeto (1,0 ponto)

Acesse o repositório do projeto no Git e clone-o para a sua máquina utilizando o terminal:

```bash
git clone <URL_DO_REPOSITÓRIO>
```

Abra o projeto na sua IDE (IntelliJ) e confirme que ele compila sem erros.

---

## 🟦 Questão 2 — Criar a Entidade e o Repository (2,0 pontos)


**a)** Crie a classe `Filme` mapeando **todos** os campos da tabela. Lembre-se de:

- Usar as anotações JPA corretas (`@Entity`, `@Table`, `@Id`, `@GeneratedValue`, `@Column`)
- Usar os tipos Java compatíveis com cada coluna SQL
- Atentar para colunas com nomes diferentes do padrão Java (ex.: `ano_lancamento`)

**b)** Crie a interface `FilmeRepository` no pacote `com.prova.filmes.repository` estendendo `JpaRepository`.

---

## 🟦 Questão 3 — Implementar o CREATE (2,0 pontos)

Crie a classe `FilmeService` no pacote `com.prova.filmes.service` (anotada com `@Service`) e implemente o método abaixo, que deve persistir um novo filme no banco utilizando o `FilmeRepository`:

```java
public Filme salvar(Filme filme) {
    // sua implementação aqui
}
```

---

## 🟦 Questão 4 — Implementar READ e DELETE (2,0 pontos)

Ainda na classe `FilmeService`, implemente os métodos:

```java
public List<Filme> listarTodos();           // retorna todos os filmes
public Filme buscarPorId(Long id);          // retorna o filme com aquele id
public void deletar(Long id);               // remove o filme pelo id
```

> ⚠️ No método `buscarPorId`, trate o caso em que o filme não existe (pode retornar `null`, lançar uma exceção, ou usar `Optional` — sua escolha, desde que justifique).

---

---
## 🟦 Questão 5 — Implementar o UPDATE (2,5 pontos)
Ainda na classe `FilmeService`, implemente um método de atualização parcial com a seguinte assinatura:
```java
public ResponseEntity<?> editar(Long id, Filme filmeAtualizado)
```
O método deve:
Buscar o filme pelo `id` usando o repository. Se não existir, lançar uma `RuntimeException` com a mensagem `"Filme não encontrado"`.
Atualizar somente os campos que vierem preenchidos (não-nulos) no objeto `filmeAtualizado` — ou seja, se o cliente mandar só o `titulo`, só o título deve mudar, e os outros campos permanecem como estavam no banco.
Salvar o filme atualizado e retornar `ResponseEntity.ok(filme)`.
Tratar a exceção com `try/catch`: em caso de erro, retornar um `ResponseEntity` apropriado contendo a mensagem do erro.
> 💡 Dica: importe `org.springframework.http.ResponseEntity` e `org.springframework.http.HttpStatus`.
---


## 🟦 Questão 6 — Consulta no Repository (2,5 pontos)

Na interface `FilmeRepository`, crie uma **consulta customizada** que retorne todos os filmes de um determinado gênero, **ordenados pela nota em ordem decrescente**.

Assinatura sugerida:

```java
List<Filme> findByGeneroOrderByNotaDesc(String genero);
```

Você pode usar:

- **Query Methods** (derivação pelo nome do método), **ou**
- A anotação `@Query` com JPQL, **ou**
- `@Query` com SQL nativo (`nativeQuery = true`)

---
