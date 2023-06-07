import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
public class App {
    public static void main(String[] args) throws Exception {
        List<Funcionario> listaFuncionario = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("1 - Adicionar funcionário | 2 - Filtrar por nome | 0 - Sair do programa ");
            System.out.println("3 - Remover item a partir do nome");
            System.out.println("4 - Apresentar média, maior e menor salário");
            opcao = sc.nextInt();

        
        

        if(opcao == 1){
        
        System.out.println("Digite o nome do funcionário: ");
        String nome = sc.next();

        System.out.println("Digite a idade do funcionário: ");
        int idade = sc.nextInt();

        System.out.println("Digite o salário do funcionário: ");
        double salario = sc.nextDouble();

        System.out.println("Digite a função do funcionário: ");
        String funcao = sc.next();

        listaFuncionario.add(new Funcionario(nome, idade, salario, funcao));

        System.out.println("*FUNCIONÁRIO*\n");


        for (Funcionario funcionario : listaFuncionario) {
            System.out.println(funcionario);
            
        }
    }

    else if(opcao == 2){
        System.out.println("Digite o nome do funcionário que deseja listar: ");
        String nome = sc.next();
       
        List<Funcionario> novalista = listaFuncionario.stream()
        .filter(p -> p .getNome().contains(nome)).collect(Collectors.toList());;
        if(novalista.isEmpty()){
            System.out.println("Não localizado!");
        }
        else{
            for (Funcionario funcionario : novalista){
                System.out.println(funcionario);
                
            }
        }
        
    } else if (opcao == 3) {
        System.out.println("Digite o nome do funcionário que deseja listar: ");
        String nome = sc.next();
        listaFuncionario.removeIf(f -> f.getNome().equals(nome));
    } else if (opcao == 4) {
        DoubleSummaryStatistics resumo = listaFuncionario.stream()
            .collect(Collectors.summarizingDouble(Funcionario::getSalario));
        System.out.printf("Média: %.2f - Maior: %.2f - Menor: %.2f",
            resumo.getAverage(), resumo.getMax(), resumo.getMin());
    }

        }while(opcao!=0);

        System.out.println("Programa finalizado");

        
    }
}
