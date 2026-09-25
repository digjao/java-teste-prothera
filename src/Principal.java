import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<>();

        // 3.1 – Adicionando lista de funcionários
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        // 3.2 – Removendo João
        removerPorNome(funcionarios, "João");

        // 3.3 – Imprimindo lista de funcionários
        System.out.println("--- LISTA DE FUNCIONÁRIOS ---");
        imprimirLista(funcionarios);

        // 3.4 – Aplicando aumento de 10%
        aplicarAumento(funcionarios, new BigDecimal("1.10"));

        System.out.println("\n--- FUNCIONÁRIOS APÓS AUMENTO DE 10% ---");
        imprimirLista(funcionarios);

        // 3.5 – Agrupando os funcionários por função em um MAP
        Map<String, List<Funcionario>> funcionariosPorFuncao = agruparPorFuncao(funcionarios);

        // 3.6 – Imprimindo os funcionários agrupados por função
        System.out.println("\n--- FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO ---");
        imprimirAgrupadoPorFuncao(funcionariosPorFuncao);

        System.out.println("\n--- CURIOSAMENTE, NÃO TEMOS 3.7 ---");

        // 3.8 – Imprimindo aniversariantes dos meses 10 e 12
        System.out.println("\n--- ANIVERSARIANTES DOS MESES 10 E 12 ---");
        imprimirAniversariantesMeses(funcionarios, 10, 12);

        // 3.9 – Imprimindo funcionário com maior idade
        System.out.println("\n--- FUNCIONÁRIO COM MAIOR IDADE ---");
        imprimirMaiorIdade(funcionarios);

        // 3.10 – Imprimindo lista por ordem alfabética
        System.out.println("\n--- FUNCIONÁRIOS EM ORDEM ALFABÉTICA ---");
        imprimirOrdemAlfabetica(funcionarios);

        // 3.11 – Imprimindo total dos salários
        System.out.println("\n--- TOTAL DOS SALÁRIOS ---");
        imprimirTotalSalarios(funcionarios);

        // 3.12 – Imprimindo quantos salários mínimos ganha cada funcionário
        System.out.println("\n--- QUANTIDADE DE SALÁRIOS MÍNIMOS POR FUNCIONÁRIO ---");
        imprimirSalariosMinimos(funcionarios, new BigDecimal("1212.00"));
    }

    public static void removerPorNome(List<Funcionario> lista, String nome) {
        lista.removeIf(f -> f.getNome().equalsIgnoreCase(nome));
    }

    public static void imprimirLista(List<Funcionario> lista) {
        DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        for (Funcionario f : lista) {
            System.out.println("Nome: " + f.getNome() +
                    " | Data Nasc: " + f.getDataNascimento().format(dtFormatter) +
                    " | Salário: " + currencyFormat.format(f.getSalario()) +
                    " | Função: " + f.getFuncao());
        }
    }

    public static void aplicarAumento(List<Funcionario> lista, BigDecimal percentual) {
        for (Funcionario f : lista) {
            BigDecimal novoSalario = f.getSalario().multiply(percentual);
            f.setSalario(novoSalario);
        }
    }

    public static Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> lista) {
        return lista.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public static void imprimirAgrupadoPorFuncao(Map<String, List<Funcionario>> mapa) {
        for (Map.Entry<String, List<Funcionario>> entry : mapa.entrySet()) {
            System.out.println("\n=== FUNÇÃO: " + entry.getKey().toUpperCase() + " ===");
            imprimirLista(entry.getValue());
        }
    }

    public static void imprimirAniversariantesMeses(List<Funcionario> lista, int... meses) {
        DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Funcionario f : lista) {
            int mesNasc = f.getDataNascimento().getMonthValue();
            for (int m : meses) {
                if (mesNasc == m) {
                    System.out.println("Nome: " + f.getNome() + " | Data Nasc: " + f.getDataNascimento().format(dtFormatter));
                    break;
                }
            }
        }
    }

    public static void imprimirMaiorIdade(List<Funcionario> lista) {
        Funcionario maisVelho = null;
        int maiorIdade = -1;

        for (Funcionario f : lista) {
            int idade = Period.between(f.getDataNascimento(), LocalDate.now()).getYears();
            if (idade > maiorIdade) {
                maiorIdade = idade;
                maisVelho = f;
            }
        }

        if (maisVelho != null) {
            System.out.println("Nome: " + maisVelho.getNome() + " | Idade: " + maiorIdade + " anos");
        }
    }
    public static void imprimirOrdemAlfabetica(List<Funcionario> lista) {
        List<Funcionario> copiaOrdenada = new ArrayList<>(lista);
        copiaOrdenada.sort(Comparator.comparing(Funcionario::getNome));
        imprimirLista(copiaOrdenada);
    }

    public static void imprimirTotalSalarios(List<Funcionario> lista) {
        BigDecimal total = BigDecimal.ZERO;
        for (Funcionario f : lista) {
            total = total.add(f.getSalario());
        }

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.println("Total dos salários: " + currencyFormat.format(total));
    }

    public static void imprimirSalariosMinimos(List<Funcionario> lista, BigDecimal salarioMinimo) {
        for (Funcionario f : lista) {
            BigDecimal qtdSalariosMinimos = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println(f.getNome() + " ganha " + qtdSalariosMinimos + " salários mínimos.");
        }
    }
}