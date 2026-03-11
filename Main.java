import java.util.Locale;
import java.util.Scanner;
import java.net.Socket;
import java.net.InetSocketAddress;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o IP: ");
        String ip = sc.next();

        System.out.println("Porta Inicial: ");
        int portaInicial = sc.nextInt();

        System.out.println("Porta Final: ");
        int portaFinal = sc.nextInt();

        System.out.println("Quantas tentativas?: ");
        int tentativas = sc.nextInt();

        try (PrintWriter writer = new PrintWriter("scannerPort.txt", "UTF-8")) {

            writer.println("Portas: ");

            for (int i = portaInicial; i <= portaFinal; i++) {
    
                String tipo1 = "";


                for (int n = tentativas; n > 0; n--) {

                    try {

                        Socket socket = new Socket();
                        socket.connect(new InetSocketAddress(ip, i), 1000);

                        switch (i) {
                            case 22:
                                tipo1 = "SSH (Acesso Remoto)";
                                break;
                            case 80:
                                tipo1 = "HTTP (Web)";
                                break;
                            case 21:
                                tipo1 = "FTP (Transferência de Arquivos)";
                                break;
                            case 443:
                                tipo1 = "HTTPS (Web Segura)";
                                break;
                            case 3306:
                                tipo1 = "MySQL (Banco de Dados)";
                                break;
                            case 5432:
                                tipo1 = "PostgreSQL (Banco de Dados)";
                                break;
                            case 8080:
                                tipo1 = "Proxy/Tomcat (Web Alternativa)";
                                break;
                            default:
                                tipo1 = "Número Desconhecido";
                                break;
                        }

                        System.out.println("A Conexão com a porta " + i + " serviço: " + tipo1 + " Foi estabelecido");
                        writer.println("A Conexão com a porta " + i + " serviço: " + tipo1 + " foi estabelecido");

                        socket.close();
                        break;
                    } catch (IOException e) {
                        System.out.println("[falha na conexão] Motivo: " + e.getMessage());
                    }
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
        System.out.println("Scan finalizado!");
        sc.close();
    }
}