package pt.exemplo.senhas.app;

import java.security.SecureRandom;
import java.util.Locale;

final class Application {
    private static final String APP_VERSION = "1.0.0";
    private static final int PASSWORD_LENGTH = 16;

    private static final char[] UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] LOWER = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] DIGITS = "0123456789".toCharArray();
    private static final char[] SPECIAL = "!@#$%^&*()-_=+[]{};:,.?/".toCharArray();
    private static final char[] ALL = (new String(UPPER) + new String(LOWER) + new String(DIGITS) + new String(SPECIAL)).toCharArray();

    private static final SecureRandom RANDOM = new SecureRandom();

    void main(String[] args) {
        var cmd = args.length == 0 ? "" : args[0].toLowerCase(Locale.ROOT);

        switch (cmd) {
            case "gerar" -> handleGerar(args);
            case "version" -> printVersion();
            case "", "help", "-h", "--help" -> printUsage();
            default -> {
                System.err.println("Comando desconhecido: " + cmd);
                printUsage();
            }
        }
    }

    private static void handleGerar(String[] args) {
        if (args.length == 1) {
            System.out.println(generatePassword());
            return;
        }

        int n;
        try {
            n = Integer.parseInt(args[1]);
        } catch (NumberFormatException ex) {
            System.err.println("N inválido. Use: gerar <N>");
            return;
        }

        if (n <= 0) {
            System.err.println("N deve ser maior que zero.");
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(generatePassword());
        }
    }

    private static String generatePassword() {
        char[] pwd = new char[PASSWORD_LENGTH];
        int idx = 0;

        pwd[idx++] = randomFrom(UPPER);   // garante 1 maiúscula
        pwd[idx++] = randomFrom(SPECIAL); // garante 1 especial

        while (idx < PASSWORD_LENGTH) {
            pwd[idx++] = randomFrom(ALL);
        }

        shuffle(pwd);
        return new String(pwd);
    }

    private static char randomFrom(char[] src) {
        return src[RANDOM.nextInt(src.length)];
    }

    private static void shuffle(char[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = RANDOM.nextInt(i + 1);
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    private static void printVersion() {
        System.out.println("Aplicação: " + APP_VERSION);
        System.out.println("Java: " + System.getProperty("java.version"));
        System.out.println(
            "Sistema Operativo: "
                + System.getProperty("os.name") + " "
                + System.getProperty("os.version") + " ("
                + System.getProperty("os.arch") + ")"
        );
    }

    private static void printUsage() {
        System.out.println("Uso:");
        System.out.println("  gerar        -> gera 1 senha");
        System.out.println("  gerar N      -> gera N senhas");
        System.out.println("  version      -> mostra versões");
    }
}