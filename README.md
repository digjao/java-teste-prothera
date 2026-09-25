# Teste Prático Java - Prothera

Projeto desenvolvido para o teste prático de programação Java. A aplicação realiza o gerenciamento e manipulação de uma lista de funcionários, cobrindo conceitos essenciais como Orientação a Objetos, Manipulação de Datas, Arredondamento Financeiro e Estruturas de Dados.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 17+ (ou Java 8+)
- **IDE Recomendada:** IntelliJ IDEA / Eclipse / VS Code
- **Build System:** Padrão Java / SDK sem dependências externas

---

## 📌 Funcionalidades Implementadas

- **3.1:** Inserção de funcionários com nome, data de nascimento, salário (`BigDecimal`) e função.
- **3.2:** Remoção de funcionário específico da lista ("João").
- **3.3:** Impressão formatada de todos os funcionários (datas no padrão `dd/mm/yyyy` e valores monetários com separador de milhar/decimal no padrão `pt-BR`).
- **3.4:** Atualização salarial com aumento de 10% para todos os funcionários.
- **3.5 & 3.6:** Agrupamento de funcionários por função em estrutura de chave/valor (`Map`) e exibição por grupo.
- **3.8:** Filtragem e exibição de aniversariantes dos meses 10 (Outubro) e 12 (Dezembro).
- **3.9:** Identificação e exibição do funcionário de maior idade (calculada dinamicamente).
- **3.10:** Ordenação alfabética e exibição da lista de funcionários sem alterar a lista original.
- **3.11:** Cálculo do total da folha de pagamento da empresa.
- **3.12:** Cálculo e exibição de quantos salários mínimos (base R$ 1.212,00) ganha cada funcionário, aplicando regras de arredondamento financeiro (`RoundingMode.HALF_UP`).

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- **JDK (Java Development Kit)** versão 17 ou superior instalada.
- **Git** instalado (opcional, para clonar).

### Passo a Passo

1. **Clonar o repositório:**
   ```bash
   git clone https://github.com/digjao/java-teste-prothera.git
   ```

2. **Navegar até à pasta do projeto:**
   ```bash
   cd java-teste-prothera
    ```
Execução via IntelliJ IDEA:

Abre o IntelliJ IDEA.

Seleciona File > Open e escolhe a pasta do projeto.

Navega até src/Principal.java.

Clica com o botão direito no ficheiro Principal.java e seleciona Run 'Principal.main()' (ou usa o atalho Shift + F10).