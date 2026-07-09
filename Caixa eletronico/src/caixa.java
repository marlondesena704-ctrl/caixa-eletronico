import java.util.Arrays;
import java.util.Scanner;

public class caixa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // declaração de variáveis e arrays
        String[] usuarios = {"RODRIGO", "DAVID", "STEVE", "PETER", "BRUCE"};
        int[] senhas = {154, 223, 359, 254, 893};
        int[] saldos = {1025, 5000, 590, 15, 3850};
        int[] notasDisponiveis = {100, 50, 20, 10, 5, 2};
        int[] notasEstoque = {40, 40, 30, 30, 15, 15};
        String usuario;
        int senhaBusca;
        int opcao;

        // inicia programa
        while (true) {
            System.out.println("SEJA BEM-VINDO!");
            System.out.println("SELECIONE UMA OPÇÃO: ");
            System.out.println("1 - ENTRAR");
            System.out.println("2 - SAIR");
            int op;

            //validação para verificar se o que foi digitado é número (int)
            // se não, o usuário deve informar novamente
            while (true) {
                if (sc.hasNextInt()) {
                    op = sc.nextInt();
                    sc.nextLine();
                    break;
                } else {
                    System.out.println("ERRO: DIGITE APENAS NÚMEROS.");
                    System.out.println("TENTE NOVAMENTE.");
                    esperar(2);
                    sc.nextLine();
                }
            }

            // se digitado 2, o programa encerra
            if (op == 2) {
                System.out.println("SISTEMA DA WAYNE-TRUST ENCERRADO.");
                break;
            }

            // pula linha
            System.out.println(new String(new char[25]).replace("\0", "\n"));

            // while principal para navegar entre os usuários e o menu de opçoes sem encerrar o programa
            loopUsuarios:
            while (true) {

                // altera usuarioEncontrado para falso toda vez que o loop volta pra cá, dessa forma o usuário informado anteriormente não irá sobrescrever,
                // assim, a senha pode ser informada corretamente também.
                if (op == 1) {
                    boolean usuarioEncontrado = false;
                    int posicaoUsuario = -1;

                    System.out.println("=====WAYNE-TRUST INTERNATIONAL ENTERPRISES=====");
                    System.out.println("ONDE VOCÊ REALIZA SEUS SONHOS.\n");
                    esperar(2);
                    System.out.printf("USUÁRIOS DISPONÍVEIS: %s%n", Arrays.toString(usuarios)); //mostra os usuários do array
                    System.out.printf("SENHAS: %s%n", Arrays.toString(senhas)); // mostra as senhas do array
                    System.out.println("INFORME O USUÁRIO: (1 PARA ENCERRAR)");
                    usuario = sc.nextLine().toUpperCase(); // transforma o nome informado para CAIXA ALTA. Caso o usuário digite em minúsculo ou caixa alta, o programa irá reconhecer.


                    if (usuario.equals("1")) {
                        System.out.println(new String(new char[25]).replace("\0", "\n"));
                        System.out.println("TERMINANDO SESSÃO...");
                        esperar(2);
                        System.out.println("SISTEMA DA WAYNE-TRUST ENCERRADO.");
                        return;
                    }

                    // validação de usuário:
                    // se for informado número ao invés de String, o programa barra a entrada e pede para informar novamente.
                    if (!usuario.matches("[A-Z ]+")) {
                        System.out.println("ERRO: O NOME DEVE CONTER APENAS LETRAS.");
                        System.out.println("TENTE NOVAMENTE.");
                        esperar(2);
                        System.out.println(new String(new char[25]).replace("\0", "\n"));
                        continue;
                    }

                    // laço de repetiçãoi para validar usuário informado no indice do array.
                    // dessa forma a senha informada também será a mesma posição do usuário,
                    for (int i = 0; i < usuarios.length; i++) {
                        if (usuario.equals(usuarios[i])) { // se o usuário informado bater com o usuário do array, o programa deixa entrar.
                            usuarioEncontrado = true;
                            posicaoUsuario = i;
                        }
                    }

                    //laço de repetição para navegar entre o menu de opçao
                    while (true) {
                        if (usuarioEncontrado) {
                            System.out.println("USUÁRIO ENCONTRADO.");

                            while (true) {
                                System.out.println("INFORME A SENHA: (1 PARA ENCERRAR)");

                                // verifica se a senha informada contém apenas números.
                                // se não, o programa informa para tentar novamente.
                                while (true) {
                                    if (sc.hasNextInt()) {
                                        senhaBusca = sc.nextInt(); // caso a senha informada esteja correta,
                                        break;                    // encerra esse laço e segue para a entrada do usuário.
                                    } else {
                                        System.out.println("ERRO: DIGITE APENAS NÚMEROS.");
                                        System.out.println("TENTE NOVAMENTE.");
                                        sc.nextLine(); // limpa o que havia sido digitado antes para não ocorrer erro ao voltar no inicio do laço.
                                    }
                                }

                                // caso digitado 1, encerra o programa.
                                if (senhaBusca == 1) {
                                    System.out.println("TERMINANDO SESSÃO...");
                                    esperar(2);
                                    System.out.println("SISTEMA DA WAYNE-TRUST ENCERRADO.");
                                    return;
                                }

                                System.out.println(new String(new char[25]).replace("\0", "\n"));

                                // valida se a senha informada corresponde ao mnesmo indice do usuário.
                                if (senhaBusca == senhas[posicaoUsuario]) {
                                    System.out.println("ENCONTRANDO DADOS DO USUÁRIO...");
                                    System.out.println("COMPILANDO SISTEMA...");
                                    esperar(2);
                                    System.out.println(new String(new char[25]).replace("\0", "\n"));

                                    // laço de repetição para navegar entre as opçoes
                                    menuOpcao:
                                    while (true) {
                                        System.out.println("OLÁ " + usuarios[posicaoUsuario] + "!");
                                        System.out.println("SELECIONE UMA OPÇÃO: ");
                                        System.out.println("1 - CONSULTAR BAT-SALDO");
                                        System.out.println("2 - REALIZAR BAT-SAQUE");
                                        System.out.println("3 - REALIZAR BAT-DEPÓSITO");
                                        System.out.println("4 - SAIR");

                                        while (true) {
                                            if (sc.hasNextInt()) {
                                                opcao = sc.nextInt(); // valida se o que foi digitado é número ou String.
                                                break; // caso sim, encerra o loop e segue para a opçao que o usuário informou - exemplo: opçao 1.
                                            } else {
                                                System.out.println("ERRO: DIGITE APENAS NÚMEROS.");
                                                System.out.println("TENTE NOVAMENTE.");
                                                sc.nextLine();
                                            }
                                        }

                                        // limpa o teclado e pula linha.
                                        sc.nextLine();
                                        System.out.println(new String(new char[25]).replace("\0", "\n"));

                                        // caso a opçao seja 1, informa o saldo do usuário.
                                        if (opcao == 1) {
                                            System.out.println("USUÁRIO: " + usuarios[posicaoUsuario]);
                                            System.out.println("SALDO DISPONÍVEL: " + saldos[posicaoUsuario] + " BAT-DÓLARES");
                                            esperar(4);
                                            System.out.println(new String(new char[25]).replace("\0", "\n"));

                                        // caso a opção escolhida seja 2, informa o saldo do usuário e pede para informar um valor para sacar.
                                        } else if (opcao == 2) {
                                            System.out.println("USUÁRIO: " + usuarios[posicaoUsuario]);
                                            System.out.println("SALDO DISPONÍVEL: " + saldos[posicaoUsuario] + " BAT-DÓLARES");
                                            System.out.println("INFORME O VALOR QUE DESEJA RETIRAR: ");
                                            int retiraValor;

                                            //laço para validação.
                                            while (true) {
                                                // verifica se o valor informado é número inteiro.
                                                if (sc.hasNextInt()) {
                                                    retiraValor = sc.nextInt();
                                                    System.out.println(new String(new char[25]).replace("\0", "\n"));

                                                    // caso o usuário tente retirar um valor maior do há no saldo, o programa barra e pede para informar novamente.
                                                    if (retiraValor > saldos[posicaoUsuario]) {
                                                        System.out.println("BAT-SALDO DISPONÍVEL É MENOR DO QUE O VALOR INFORMADO PARA RETIRADA.");
                                                        System.out.println("TENTE NOVAMENTE.");
                                                        continue menuOpcao;

                                                    // verifica se o valor informado é negativo.
                                                    } else if (retiraValor < 0) {
                                                        System.out.println("O VALOR INFORMADO NÃO EXISTE.");
                                                        System.out.println("TENTE NOVAMENTE.");
                                                        continue menuOpcao;
                                                    }

                                                    sc.nextLine();
                                                    break;

                                                // verifica se foi digitado String ao invés de número inteiro.
                                                } else {
                                                    System.out.println("ERRO: DIGITE APENAS NÚMEROS.");
                                                    System.out.println("TENTE NOVAMENTE.");
                                                    sc.nextLine();
                                                }
                                            }

                                            // segue para a retirada de valor.
                                            System.out.println("PROCESSANDO OPERAÇÃO...");
                                            esperar(1);
                                            System.out.println(new String(new char[25]).replace("\0", "\n"));
                                            System.out.println("VALOR TOTAL RETIRADO: " + retiraValor);
                                            System.out.println("SEU SALDO ATUAL É DE: " + (saldos[posicaoUsuario] = saldos[posicaoUsuario] - retiraValor) + " BAT-DÓLARES");
                                            System.out.println("NOTAS ENTREGUES: ");

                                            // laço de repetição para verificar as notas entregues.
                                            for (int i = 0; i < notasDisponiveis.length; i++) {
                                                int quantidade = retiraValor / notasDisponiveis[i];

                                                // se a quantidade for maior que zero, segue para retirada de valor.
                                                // se a quantidade for maior que o estoque das notas, a quantidade será esse estoque na posição do i.
                                                if (quantidade > 0) {
                                                    if (quantidade > notasEstoque[i]) {
                                                        quantidade = notasEstoque[i];
                                                    }

                                                    // o valor de saque é abatido da quantidade * notasDisponiveis[i].
                                                    // dessa forma, caso o estoque da nota de 100 termine e ainda sobre valor para retirar,
                                                    // o laço segue para a próxima nota: nota de 50 e assim por diante.
                                                    retiraValor -= quantidade * notasDisponiveis[i];
                                                    notasEstoque[i] -= quantidade; // atualiza o estoque das notas.
                                                    System.out.println(notasDisponiveis[i] + " BAT-DÓLARES: " + quantidade); // imprime o VALOR das notas e a quantidade entregue delas.
                                                }
                                            }

                                            esperar(4);
                                            System.out.println(new String(new char[25]).replace("\0", "\n"));

                                            // mostra o saldo das notas atualizado após o saque.
                                            System.out.println("SALDO DISPONÍVEL DO CAIXA ELETRÔNICO: ");
                                            System.out.println("NOTA 100: " + notasEstoque[0] + "\nNOTA 50: " + notasEstoque[1]);
                                            System.out.println("NOTA 20: " + notasEstoque[2] + "\nNOTA 10: " + notasEstoque[3] + "\nNOTA 5: " + notasEstoque[4]);
                                            esperar(4);
                                            System.out.println(new String(new char[25]).replace("\0", "\n"));

                                        // caso escolhida opção 3, o usuário irá depositar um valor que irá ser adicionado ao saldo já preexistente.
                                        } else if (opcao == 3) {
                                            System.out.println("USUÁRIO: " + usuarios[posicaoUsuario]);
                                            System.out.println("SALDO DISPONÍVEL: " + saldos[posicaoUsuario] + " BAT-DÓLARES");
                                            System.out.println("INFORME O VALOR QUE DESEJA DEPOSITAR: ");
                                            int depositaValor;

                                            while (true) {
                                                // valida de o valor informado é número.
                                                if (sc.hasNextInt()) {
                                                    depositaValor = sc.nextInt();

                                                    // caso o valor informado seja negativo, o programa barra o depósito e pede para tentar novamente.
                                                    if (depositaValor < 0) {
                                                        System.out.println("O VALOR INFORMADO NÃO EXISTE.");
                                                        System.out.println("TENTE NOVAMENTE.");
                                                        esperar(2);
                                                        System.out.println(new String(new char[25]).replace("\0", "\n"));
                                                        continue menuOpcao;
                                                    }
                                                    // limpa o teclado.
                                                    sc.nextLine();
                                                    break;

                                                // caso o usuário informe String, o programa barra o depósito.
                                                } else {
                                                    System.out.println("ERRO: DIGITE APENAS NÚMEROS.");
                                                    System.out.println("TENTE NOVAMENTE.");
                                                    sc.nextLine();
                                                }
                                            }

                                            // se o usuário informou o valor dentro das condições, o depósito é feito
                                            System.out.println("PROCESSANDO OPERAÇÃO...");
                                            esperar(2);
                                            System.out.println(new String(new char[25]).replace("\0", "\n"));
                                            System.out.println("DEPÓSITO NO VALOR DE " + depositaValor + " BAT-DÓLARES CONCLUÍDA."); // mostra o valor depositado
                                            System.out.println("SEU SALDO ATUAL É DE: " + (saldos[posicaoUsuario] = saldos[posicaoUsuario] + depositaValor) + " BAT-DÓLARES"); // atualiza o valor depositado na conta do  usuário.
                                            esperar(4);
                                            System.out.println(new String(new char[25]).replace("\0", "\n"));

                                        // caso seja informada a opção 4, o usuário sai do menu e é levado para o laço onde irá escolher novamente o usuário que deseja continuar.
                                        } else if (opcao == 4) {
                                            System.out.println("AGRADEÇEMOS SUA CONFIANÇA NA WAYNE-TRUST!");
                                            System.out.println("AQUI, NÓS PREZAMOS PELA SUA SEGURANÇA.\n");
                                            System.out.println("SAINDO... AGUARDE.");
                                            esperar(2);
                                            System.out.println(new String(new char[25]).replace("\0", "\n"));
                                            continue loopUsuarios;

                                        // caso seja informado um número fora das opçoes dadas, o programa barra e pede para tentar novamente.
                                        } else {
                                            System.out.println("OPÇÃO INVÁLIDA. TENTE NOVAMENTE.");
                                        }
                                    }

                                // caso a senha informada esteja incorreta, o programa barra a entrada do usuário no sistema.
                                } else {
                                    System.out.println("SENHA INCORRETA. TENTE NOVAMENTE.");
                                    System.out.println("DICA: CONTÉM TRÊS NÚMEROS.");
                                    sc.nextLine();
                                    break;
                                }
                            }

                        // caso o usuário informado seja diferente do que há no array, o programa informa e pede para tentar novamente.
                        } else {
                            System.out.println("USUÁRIO NÃO ENCONTRADO. TENTE NOVAMENTE.");
                            System.out.println(new String(new char[25]).replace("\0", "\n"));
                            continue loopUsuarios;
                        }
                    }

                    // dada as opçoes 1 e 2 no iníco do programa, caso seja informado um número diferente desses dois valores,
                    // o programa barra a entrada e pede para tentar novamente.
                } else {
                    System.out.println("OPÇÃO INVÁLIDA. TENTE NOVAMENTE.");
                    break;
                }
            }
        }
    }

    // funçao para poder executar o comando "(esperar 2 segundos").
    public static void esperar(int segundos) { // nome da variável.
        try {
            Thread.sleep(segundos * 1000L); // como o tempo é em milisegundos, é feita multiplação por mil para transformar em segundos.
                                            //1000L para garantir o número do tipo long.
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}