package cmd;

public class Main {
    String testNetwork =
              "c { def X {a!<pwd>; a&{ok: s?; stop, ko: X}} main {X}} " +
            "| a { def X {c?; s?; if s then c+ok; s+ok; stop else c+ko; s+ko; X} main {X}} " +
            "| s { def X {a!<s>; a&{ok: c!<t>; stop, ko:X}} main {X}}";

    public static void main(String[] args){
        System.out.println("Hello World!");

    }
}
