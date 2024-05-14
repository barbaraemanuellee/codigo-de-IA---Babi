import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AgenteLogicoAI {
    // Definição das regras
    private static final Map<String, String> regras = new HashMap<>();
    static {
        regras.put("ensolarado_nao_ventando", "jogar tênis");
        regras.put("ensolarado_ventando", "não jogar tênis");
        regras.put("chuvoso_temperatura_quente", "ir nadar");
        regras.put("chuvoso_temperatura_fria", "assistir TV em casa");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Condições climáticas:");
        System.out.print("Está ensolarado? (sim/não): ");
        String ensolarado = scanner.nextLine();

        System.out.print("Está ventando? (sim/não): ");
        String ventando = scanner.nextLine();

        System.out.println("Temperatura (quente/fria): ");
        String temperatura = scanner.nextLine();

        // Construir chave da regra com base nas entradas
        String chaveRegra = ensolarado.toLowerCase() + "_" + (ventando.equalsIgnoreCase("sim") ? "ventando" : "nao_ventando");
        if (chaveRegra.equals("chuvoso")) {
            chaveRegra += "_" + temperatura.toLowerCase();
        }

        // Consultar regras e tomar decisão
        String decisao = consultarRegra(chaveRegra);
        if (decisao != null) {
            System.out.println("Decisão: " + decisao);
        } else {
            System.out.println("Não há regra para essas condições.");
        }

        scanner.close();
    }

    // Método para consultar as regras
    private static String consultarRegra(String chaveRegra) {
        return regras.get(chaveRegra);
    }
}
