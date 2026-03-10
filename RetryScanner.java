import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.net.InetSocketAddress;

public class RetryScanner {
    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        char resposta = '0';

        do {
            System.out.println("Digite o Ip: ");
            String ip = sc.next();

            System.out.println("Porta: ");
            int porta = sc.nextInt();

            System.out.println("Quantas tentativas?: ");
            int tentativas = sc.nextInt();

            for (int i=tentativas; i > 0; i--) {


                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(ip, porta), 1000);

                    System.out.println("A Conexão com a Porta " + porta + " Foi estabelecida");

                    socket.close();
                    break;
                } catch (IOException e) {
                    System.out.println("[falha na conexão] Motivo: " + e.getMessage());
                }
            }

        System.out.println("Deseja continuar? (s/n): ");
        resposta = sc.next().charAt(0);

        } while (resposta == 's' || resposta == 'S');
        sc.close();
    }
}
