import java.util.Arrays;
import java.util.Scanner;

public class caixa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] usuarios = {"RODRIGO", "DAVID", "STEVE", "PETER", "BRUCE"};
        int[] senhas = {154, 223, 359, 254, 893};
        int[] saldos = {1024, 5000, 584, 15, 99999};
        int[] notasDisponiveis = {200, 100, 50, 20, 10, 5, 2};
        String usuario;
        int senhaBusca;
        int opcao;

        while (true) {

            System.out.println("SEJA BEM-VINDO!");
            System.out.println("SELECIONE UMA OPÇÃO: ");
            System.out.println("1 - ENTRAR");
            System.out.println("2 - SAIR");
            int op;

            while (true) {
                if (sc.hasNextInt()) {
                    op = sc.nextInt();
                    sc.nextLine();
                    break;
                } else {
                    System.out.println("ERRO: DIGITE APENAS NÚMEROS.");
                    System.out.println("TENTE NOVAMENTE.");
                    sc.nextLine();
                }
            }

            if (op == 2) {
                System.out.println("SISTEMA DA WAYNE-TRUST ENCERRADO.");
                break;
            }

            System.out.println(new String(new char[25]).replace("\0", "\n"));

            loopUsuarios:
            while (true) {
                if (op == 1) {

                    boolean usuarioEncontrado = false;
                    int posicaoUsuario = -1;

                    System.out.println("=====WAYNE-TRUST INTERNATIONAL ENTERPRISES=====");
                    System.out.println("ONDE VOCÊ REALIZA SEUS SONHOS.\n");
                    esperar(2);
                    System.out.printf("USUÁRIOS DISPONÍVEIS: %s%n", Arrays.toString(usuarios));
                    System.out.printf("SENHAS: %s%n", Arrays.toString(senhas));
                    System.out.println("INFORME O USUÁRIO: (1 PARA ENCERRAR)");
                    usuario = sc.nextLine().toUpperCase();

                    if (usuario.equals("1")) {
                        System.out.println(new String(new char[25]).replace("\0", "\n"));
                        System.out.println("TERMINANDO SESSÃO...");
                        esperar(2);
                        System.out.println("SISTEMA DA WAYNE-TRUST ENCERRADO.");
                        return;
                    }

                    if (!usuario.matches("[A-Z ]+")) {
                        System.out.println("ERRO: O NOME DEVE CONTER APENAS LETRAS.");
                        System.out.println("TENTE NOVAMENTE.");
                        continue;
                    }

                    for (int i = 0; i < usuarios.length; i++) {
                        if (usuario.equals(usuarios[i])) {
                            usuarioEncontrado = true;
                            posicaoUsuario = i;
                        }
                    }

                    while (true) {
                        if (usuarioEncontrado) {
                            System.out.println("USUÁRIO ENCONTRADO.");

                            while (true) {
                                System.out.println("INFORME A SENHA: (1 PARA ENCERRAR)");

                                while (true) {
                                    if (sc.hasNextInt()) {
                                        senhaBusca = sc.nextInt();
                                        break;
                                    } else {
                                        System.out.println("ERRO: DIGITE APENAS NÚMEROS.");
                                        System.out.println("TENTE NOVAMENTE.");
                                        sc.nextLine();
                                    }
                                }

                                if (senhaBusca == 1) {
                                    System.out.println("TERMINANDO SESSÃO...");
                                    esperar(2);
                                    System.out.println("SISTEMA DA WAYNE-TRUST ENCERRADO.");
                                    return;
                                }

                                System.out.println(new String(new char[25]).replace("\0", "\n"));

                                if (senhaBusca == senhas[posicaoUsuario]) {

                                    System.out.println("ENCONTRANDO DADOS DO USUÁRIO...");
                                    System.out.println("COMPLIANDO SISTEMA...");
                                    esperar(2);
                                    System.out.println(new String(new char[25]).replace("\0", "\n"));

                                    menuOpcao:
                                    while (true) {

                                        System.out.println("OLÁ " + usuarios[posicaoUsuario] + "!");
                                        System.out.println("SELECIONE UMA OPÇÃO: ");
                                        System.out.println("1 - CONSULTAR BAT-DÓLARES");
                                        System.out.println("2 - REALIZAR SAQUE");
                                        System.out.println("3 - REALIZAR DEPÓSITO");
                                        System.out.println("4 - SAIR");

                                        while (true) {
                                            if (sc.hasNextInt()) {
                                                opcao = sc.nextInt();
                                                break;
                                            } else {
                                                System.out.println("ERRO: DIGITE APENAS NÚMEROS.");
                                                System.out.println("TENTE NOVAMENTE.");
                                                sc.nextLine();
                                            }
                                        }

                                        sc.nextLine();

                                        System.out.println(new String(new char[25]).replace("\0", "\n"));

                                        if (opcao == 1) {

                                            System.out.println("USUÁRIO: " + usuarios[posicaoUsuario]);
                                            System.out.println("SALDO DISPONÍVEL: " + saldos[posicaoUsuario] + " BAT-DÓLARES");
                                            esperar(4);
                                            System.out.println(new String(new char[25]).replace("\0", "\n"));

                                        } else if (opcao == 2) {

                                            System.out.println("USUÁRIO: " + usuarios[posicaoUsuario]);
                                            System.out.println("SALDO DISPONÍVEL: " + saldos[posicaoUsuario] + " BAT-DÓLARES");
                                            System.out.println("INFORME O VALOR QUE DESEJA RETIRAR: ");
                                            int retiraValor;

                                            while (true) {
                                                if (sc.hasNextInt()) {
                                                    retiraValor = sc.nextInt();
                                                    System.out.println(new String(new char[25]).replace("\0", "\n"));

                                                    if (retiraValor > saldos[posicaoUsuario]) {
                                                        System.out.println("O SALDO DISPONÍVEL É MENOR DO QUE O VALOR INFORMADO PARA RETIRADA.");
                                                        System.out.println("TENTE NOVAMENTE.");
                                                        esperar(2);
                                                        System.out.println(new String(new char[25]).replace("\0", "\n"));
                                                        continue menuOpcao;
                                                    } else if (retiraValor < 0) {
                                                        System.out.println("O VALOR INFORMADO NÃO EXISTE.");
                                                        System.out.println("TENTE NOVAMENTE.");
                                                        esperar(2);
                                                        System.out.println(new String(new char[25]).replace("\0", "\n"));
                                                        continue menuOpcao;
                                                    }

                                                    sc.nextLine();
                                                    break;
                                                } else {
                                                    System.out.println("ERRO: DIGITE APENAS NÚMEROS.");
                                                    System.out.println("TENTE NOVAMENTE.");
                                                    sc.nextLine();
                                                }
                                            }

                                            System.out.println("PROCESSANDO OPERAÇÃO...");
                                            esperar(1);
                                            System.out.println(new String(new char[25]).replace("\0", "\n"));
                                            System.out.println("RETIRADA NO VALOR DE " + retiraValor + " BAT-DÓLARES CONCLUÍDA.");
                                            System.out.println("SEU SALDO ATUAL É DE: " + (saldos[posicaoUsuario] = saldos[posicaoUsuario] - retiraValor) + " BAT-DÓLARES");
                                            System.out.println("NOTAS ENTREGUES: ");

                                            for (int i = 0; i < notasDisponiveis.length; i++) {
                                                int quantidade = retiraValor / notasDisponiveis[i];
                                                retiraValor %= notasDisponiveis[i];
                                                if (quantidade > 0) {
                                                    System.out.println(notasDisponiveis[i] + " BAT-DÓLARES: " + quantidade);
                                                }
                                            }

                                            esperar(4);
                                            System.out.println(new String(new char[25]).replace("\0", "\n"));

                                        } else if (opcao == 3) {

                                            System.out.println("USUÁRIO: " + usuarios[posicaoUsuario]);
                                            System.out.println("SALDO DISPONÍVEL: " + saldos[posicaoUsuario] + " BAT-DÓLARES");
                                            System.out.println("INFORME O VALOR QUE DESEJA DEPOSITAR: ");
                                            int depositaValor;

                                            while (true) {
                                                if (sc.hasNextInt()) {
                                                    depositaValor = sc.nextInt();
                                                    sc.nextLine();
                                                    break;
                                                } else {
                                                    System.out.println("ERRO: DIGITE APENAS NÚMEROS.");
                                                    System.out.println("TENTE NOVAMENTE.");
                                                    sc.nextLine();
                                                }
                                            }

                                            System.out.println("PROCESSANDO OPERAÇÃO...");
                                            esperar(1);
                                            System.out.println(new String(new char[25]).replace("\0", "\n"));
                                            System.out.println("DEPÓSITO NO VALOR DE " + depositaValor + " BAT-DÓLARES CONCLUÍDA.");
                                            System.out.println("SEU SALDO ATUAL É DE: " + (saldos[posicaoUsuario] = saldos[posicaoUsuario] + depositaValor) + " BAT-DÓLARES");
                                            esperar(4);
                                            System.out.println(new String(new char[25]).replace("\0", "\n"));

                                        } else if (opcao == 4) {

                                            System.out.println("AGRADEÇEMOS SUA CONFIANÇA NA WAYNE-TRUST!");
                                            System.out.println("AQUI, NÓS PREZAMOS PELA SUA SEGURANÇA.\n");
                                            System.out.println("SAINDO... AGUARDE.");
                                            esperar(2);
                                            System.out.println(new String(new char[25]).replace("\0", "\n"));
                                            continue loopUsuarios;

                                        } else {
                                            System.out.println("OPÇÃO INVÁLIDA. TENTE NOVAMENTE.");
                                        }
                                    }

                                } else {
                                    System.out.println("SENHA INCORRETA. TENTE NOVAMENTE.");
                                    System.out.println("DICA: CONTÉM TRÊS NÚMEROS.");
                                    sc.nextLine();
                                    break;
                                }
                            }

                        } else {
                            System.out.println("USUÁRIO NÃO ENCONTRADO. TENTE NOVAMENTE.");
                            continue loopUsuarios;
                        }
                    }

                } else {
                    System.out.println("OPÇÃO INVÁLIDA. TENTE NOVAMENTE.");
                    break;
                }
            }
        }
    }

    public static void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {

        }
    }
}