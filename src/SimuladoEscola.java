import java.util.*;

public class SimuladoEscola {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> alunos = new ArrayList<>();
        Map<String, Double> notas = new HashMap<>();

        int opcao = 0;

        do {
            System.out.println("\n1-Cadastrar aluno");
            System.out.println("2-Remover aluno");
            System.out.println("3-Dar nota");
            System.out.println("4-Editar nota");
            System.out.println("5-Ver alunos");
            System.out.println("6-Sair");

            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {

                case 1:
                    System.out.println("Digite o nome do aluno:");
                    String nome = sc.nextLine();

                    if (!alunos.contains(nome)) {
                        alunos.add(nome);
                        System.out.println("Aluno cadastrado.");
                    } else {
                        System.out.println("Aluno já existe.");
                    }
                    break;

                case 2:
                    System.out.println("Digite o nome do aluno para remover:");
                    String remover = sc.nextLine();

                    if (alunos.remove(remover)) {
                        notas.remove(remover);
                        System.out.println("Aluno removido.");
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Digite o nome do aluno:");
                    String alunoNota = sc.nextLine();

                    if (alunos.contains(alunoNota)) {
                        System.out.println("Digite a nota:");
                        double nota = sc.nextDouble();
                        sc.nextLine();

                        notas.put(alunoNota, nota);
                        System.out.println("Nota adicionada.");
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Digite o nome do aluno:");
                    String editar = sc.nextLine();

                    if (notas.containsKey(editar)) {
                        System.out.println("Digite a nova nota:");
                        double novaNota = sc.nextDouble();
                        sc.nextLine();

                        notas.put(editar, novaNota);
                        System.out.println("Nota atualizada.");
                    } else {
                        System.out.println("Aluno não tem nota cadastrada.");
                    }
                    break;

                case 5:
                    System.out.println("\nLista de alunos:");
                    for (String a : alunos) {
                        if (notas.containsKey(a)) {
                            System.out.println(a + " - Nota: " + notas.get(a));
                        } else {
                            System.out.println(a + " - Sem nota");
                        }
                    }
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 6);

        sc.close();
    }
}