import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calc = new Calculadora();
        double resultado = 0;

        while (true) {
            System.out.println("Digite a expressão (exemplo: 2 + 2 - 3 ou para raiz quadrada sqrt 4) ou 'C' para limpar ou 'off' para sair:");
            String expressao = scanner.nextLine();

            if (expressao.equalsIgnoreCase("C")) {
                resultado = 0;
                System.out.println("Calculadora zerada!");
                continue;
            } else if (expressao.equalsIgnoreCase("off")) {
                System.out.println("Calculadora desligada!");
                break;
            }

            try {
                resultado = calc.calcular(expressao);
                System.out.println("= " + resultado);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
    }

    public double calcular(String expressao) {
        if (expressao.isEmpty()) {
            throw new IllegalArgumentException("Erro: Expressão vazia não é permitida.");
        }

        String[] partes = expressao.split(" ");
        double resultado = 0;

        if (partes[0].equals("sqrt")) {
            resultado = Math.sqrt(Double.parseDouble(partes[1]));
        } else {
            resultado = Double.parseDouble(partes[0]);

            for (int i = 1; i < partes.length; i += 2) {
                String operacao = partes[i];
                double num = Double.parseDouble(partes[i + 1]);

                if (operacao.equals("+")) {
                    resultado += num;
                } else if (operacao.equals("-")) {
                    resultado -= num;
                } else if (operacao.equals("*")) {
                    resultado *= num;
                } else if (operacao.equals("/")) {
                    if (num != 0) {
                        resultado /= num;
                    } else {
                        throw new IllegalArgumentException("Erro: Divisão por zero não é permitida.");
                    }
                } else if (operacao.equals("%")) {
                    resultado %= num;
                } else {
                    throw new IllegalArgumentException("Operação inválida.");
                }
            }
        }

        return resultado;
    }
}

