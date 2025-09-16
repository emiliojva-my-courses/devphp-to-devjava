package fundamentals.examples;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Collections em Java vs Arrays em PHP
 * 
 * Este exercício mostra como trabalhar com coleções em Java,
 * sempre comparando com as funções de array do PHP que você já conhece.
 * 
 * PHP Arrays são "mágicos" - Java Collections são tipadas e específicas.
 */
public class CollectionsExample {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("📦 COLLECTIONS: DO PHP PARA JAVA");
        System.out.println("========================================\n");

        // ==========================================
        // 1. LISTA (PHP array indexado)
        // ==========================================
        phpStyleArrays();
        
        // ==========================================
        // 2. MAPA (PHP array associativo)
        // ==========================================
        phpStyleAssociativeArrays();
        
        // ==========================================
        // 3. FUNÇÕES DE ARRAY (PHP vs Java Streams)
        // ==========================================
        phpStyleArrayFunctions();
        
        // ==========================================
        // 4. OPERAÇÕES AVANÇADAS
        // ==========================================
        advancedCollectionOperations();
    }

    /**
     * 🔢 LISTAS: Como PHP array indexado
     * 
     * PHP: $nomes = ["João", "Maria", "Pedro"];
     * Java: List<String> nomes = List.of("João", "Maria", "Pedro");
     */
    private static void phpStyleArrays() {
        System.out.println("🔢 1. LISTAS (PHP array indexado)");
        System.out.println("PHP: $nomes = [\"João\", \"Maria\", \"Pedro\"];");
        
        // Criando lista mutável (pode modificar)
        List<String> nomes = new ArrayList<>();
        nomes.add("João");
        nomes.add("Maria");
        nomes.add("Pedro");
        
        System.out.println("Java: List<String> nomes = " + nomes);
        
        // Acessando elementos (como PHP $nomes[0])
        System.out.println("Primeiro nome: " + nomes.get(0) + " (como PHP $nomes[0])");
        
        // Tamanho da lista (como PHP count($nomes))
        System.out.println("Total de nomes: " + nomes.size() + " (como PHP count($nomes))");
        
        // Verificar se existe (como PHP in_array())
        boolean temJoao = nomes.contains("João");
        System.out.println("Tem João? " + temJoao + " (como PHP in_array('João', $nomes))");
        
        // Adicionar elemento (como PHP $nomes[] = "Ana")
        nomes.add("Ana");
        System.out.println("Após adicionar Ana: " + nomes);
        
        System.out.println();
    }

    /**
     * 🗝️ MAPAS: Como PHP array associativo
     * 
     * PHP: $usuario = ["nome" => "João", "idade" => 30];
     * Java: Map<String, Object> usuario = Map.of("nome", "João", "idade", 30);
     */
    private static void phpStyleAssociativeArrays() {
        System.out.println("🗝️ 2. MAPAS (PHP array associativo)");
        System.out.println("PHP: $usuario = [\"nome\" => \"João\", \"idade\" => 30];");
        
        // Criando mapa mutável
        Map<String, Object> usuario = new HashMap<>();
        usuario.put("nome", "João");
        usuario.put("idade", 30);
        usuario.put("ativo", true);
        usuario.put("email", "joao@email.com");
        
        System.out.println("Java: Map<String, Object> usuario = " + usuario);
        
        // Acessando valores (como PHP $usuario["nome"])
        String nome = (String) usuario.get("nome");
        System.out.println("Nome: " + nome + " (como PHP $usuario['nome'])");
        
        // Verificar se chave existe (como PHP isset($usuario["nome"]))
        boolean temNome = usuario.containsKey("nome");
        System.out.println("Tem nome? " + temNome + " (como PHP isset($usuario['nome']))");
        
        // Listar todas as chaves (como PHP array_keys($usuario))
        Set<String> chaves = usuario.keySet();
        System.out.println("Chaves: " + chaves + " (como PHP array_keys($usuario))");
        
        System.out.println();
    }

    /**
     * 🔄 FUNÇÕES DE ARRAY: PHP vs Java Streams
     * 
     * PHP tem array_filter, array_map, array_reduce
     * Java tem Stream API com filter, map, reduce
     */
    private static void phpStyleArrayFunctions() {
        System.out.println("🔄 3. FUNÇÕES DE ARRAY (PHP vs Java Streams)");
        
        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Números originais: " + numeros);
        
        // ==========================================
        // FILTRAR (PHP array_filter)
        // ==========================================
        System.out.println("\n📋 FILTRAR:");
        System.out.println("PHP: array_filter($numeros, fn($n) => $n % 2 == 0)");
        
        List<Integer> pares = numeros.stream()
            .filter(n -> n % 2 == 0)  // Só números pares
            .collect(Collectors.toList());
        
        System.out.println("Java Streams: " + pares);
        
        // ==========================================
        // MAPEAR (PHP array_map)
        // ==========================================
        System.out.println("\n🔄 MAPEAR:");
        System.out.println("PHP: array_map(fn($n) => $n * 2, $numeros)");
        
        List<Integer> dobrados = numeros.stream()
            .map(n -> n * 2)  // Multiplica por 2
            .collect(Collectors.toList());
        
        System.out.println("Java Streams: " + dobrados);
        
        // ==========================================
        // COMBINAR OPERAÇÕES (PHP: várias funções)
        // ==========================================
        System.out.println("\n⚡ COMBINAR (Filtrar + Mapear):");
        System.out.println("PHP: array_map(fn($n) => $n * 2, array_filter($numeros, fn($n) => $n > 5))");
        
        List<Integer> filtradoEDobrado = numeros.stream()
            .filter(n -> n > 5)    // Só maiores que 5
            .map(n -> n * 2)       // Multiplica por 2
            .collect(Collectors.toList());
        
        System.out.println("Java Streams: " + filtradoEDobrado);
        
        // ==========================================
        // REDUZIR (PHP array_reduce)
        // ==========================================
        System.out.println("\n🎯 REDUZIR:");
        System.out.println("PHP: array_reduce($numeros, fn($acc, $n) => $acc + $n, 0)");
        
        int soma = numeros.stream()
            .reduce(0, (acc, n) -> acc + n);  // Soma todos
        
        System.out.println("Java Streams - Soma: " + soma);
        
        System.out.println();
    }

    /**
     * 🚀 OPERAÇÕES AVANÇADAS
     * 
     * Exemplos práticos que você usaria no dia a dia,
     * simulando cenários reais como manipular dados de usuários.
     */
    private static void advancedCollectionOperations() {
        System.out.println("🚀 4. OPERAÇÕES AVANÇADAS (Cenário Real)");
        
        // Simulando dados de usuários (como vindo de um banco ou API)
        List<Map<String, Object>> usuarios = List.of(
            Map.of("id", 1, "nome", "João", "idade", 25, "ativo", true, "email", "joao@email.com"),
            Map.of("id", 2, "nome", "Maria", "idade", 30, "ativo", false, "email", "maria@email.com"),
            Map.of("id", 3, "nome", "Pedro", "idade", 22, "ativo", true, "email", "pedro@email.com"),
            Map.of("id", 4, "nome", "Ana", "idade", 35, "ativo", true, "email", "ana@email.com")
        );
        
        System.out.println("👥 Usuários: " + usuarios.size() + " registros");
        
        // ==========================================
        // Filtrar usuários ativos (como WHERE ativo = true)
        // ==========================================
        System.out.println("\n✅ Usuários ativos:");
        List<String> usuariosAtivos = usuarios.stream()
            .filter(user -> (Boolean) user.get("ativo"))
            .map(user -> (String) user.get("nome"))
            .collect(Collectors.toList());
        
        System.out.println("PHP: array_filter($usuarios, fn($u) => $u['ativo'])");
        System.out.println("Java: " + usuariosAtivos);
        
        // ==========================================
        // Usuários maiores de 25 anos
        // ==========================================
        System.out.println("\n🎂 Usuários com mais de 25 anos:");
        List<String> usuariosMaduros = usuarios.stream()
            .filter(user -> (Integer) user.get("idade") > 25)
            .map(user -> user.get("nome") + " (" + user.get("idade") + " anos)")
            .collect(Collectors.toList());
        
        System.out.println(usuariosMaduros);
        
        // ==========================================
        // Agrupar por status (ativo/inativo)
        // ==========================================
        System.out.println("\n📊 Agrupamento por status:");
        Map<Boolean, List<String>> agrupadoPorStatus = usuarios.stream()
            .collect(Collectors.groupingBy(
                user -> (Boolean) user.get("ativo"),
                Collectors.mapping(
                    user -> (String) user.get("nome"),
                    Collectors.toList()
                )
            ));
        
        System.out.println("Ativos: " + agrupadoPorStatus.get(true));
        System.out.println("Inativos: " + agrupadoPorStatus.get(false));
        
        // ==========================================
        // Estatísticas (como SQL agregações)
        // ==========================================
        System.out.println("\n📈 Estatísticas:");
        
        OptionalDouble idadeMedia = usuarios.stream()
            .mapToInt(user -> (Integer) user.get("idade"))
            .average();
        
        OptionalInt idadeMaxima = usuarios.stream()
            .mapToInt(user -> (Integer) user.get("idade"))
            .max();
        
        long totalAtivos = usuarios.stream()
            .filter(user -> (Boolean) user.get("ativo"))
            .count();
        
        System.out.println("Idade média: " + (idadeMedia.isPresent() ? String.format("%.1f", idadeMedia.getAsDouble()) : "N/A"));
        System.out.println("Idade máxima: " + (idadeMaxima.isPresent() ? idadeMaxima.getAsInt() : "N/A"));
        System.out.println("Total de ativos: " + totalAtivos);
        
        System.out.println("\n🎉 Collections dominadas! Próximo passo: OOP avançado");
    }
}
