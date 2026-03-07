package com.scalamentis.modulos.modulo1.labs.integrador;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 🧪 PROYECTO INTEGRADOR - MODULO 1
 *
 * Objetivo del laboratorio:
 * Comparar una implementación "legado" de Java
 * con una versión refactorizada usando Java moderno.
 *
 * Conceptos aplicados:
 * - Collections
 * - Generics
 * - Streams
 * - API moderna de tiempo (Instant)
 * - Buenas prácticas de código
 */
public class ProyectoIntegrador {

    public static void main(String[] args) {

        PedidoProcessor legacy = new PedidoProcessor();
        PedidoProcessorRefactorizado moderno = new PedidoProcessorRefactorizado();

        legacy.agregarPedido("A100");
        legacy.agregarPedido("B200");
        legacy.agregarPedido("A100");
        legacy.agregarPedido("A300");

        moderno.agregarPedido("A100");
        moderno.agregarPedido("B200");
        moderno.agregarPedido("A100");
        moderno.agregarPedido("A300");

        // 🔥 WARMUP (para que el JIT optimice)
        for (int i = 0; i < 10000; i++) {
            legacy.procesar();
            moderno.procesar();
        }

        int iteraciones = 100000;

        long inicioLegacy = System.nanoTime();

        for (int i = 0; i < iteraciones; i++) {
            legacy.procesar();
        }

        long finLegacy = System.nanoTime();

        long inicioModerno = System.nanoTime();

        for (int i = 0; i < iteraciones; i++) {
            moderno.procesar();
        }

        long finModerno = System.nanoTime();

        long tiempoLegacy = (finLegacy - inicioLegacy) / iteraciones;
        long tiempoModerno = (finModerno - inicioModerno) / iteraciones;

        System.out.println("Resumen legacy: " + legacy.getResumen());
        System.out.println("Tiempo promedio legacy (ns): " + tiempoLegacy);

        System.out.println();

        System.out.println("Resumen moderno: " + moderno.getResumen());
        System.out.println("Tiempo promedio moderno (ns): " + tiempoModerno);
    }
    /**
     * IMPLEMENTACIÓN LEGACY
     *
     * Este código refleja prácticas comunes en Java antiguo.
     * Se mantiene así para fines educativos.
     */
    static class PedidoProcessor {

        // Lista de pedidos sin generics (mala práctica)
        private List pedidos = new ArrayList<>();

        // Historial sin tipos seguros
        private Map historial = new HashMap();

        // Uso de API antigua de fecha
        private Date fechaUltimoProceso;

        // Estado del procesador
        private boolean activo;

        // Constructor
        public PedidoProcessor() {
            activo = true;
        }

        /**
         * Agrega un pedido a la lista
         */
        public void agregarPedido(Object p) {
            pedidos.add(p);
        }

        /**
         * Construye un resumen manual del historial
         */
        public String getResumen() {

            // String mutable (ineficiente)
            String s = "";

            // Iterador manual
            Iterator it = historial.keySet().iterator();

            while (it.hasNext()) {

                Object key = it.next();

                // Concatenación repetida (mala práctica)
                s += key.toString() + ":" + historial.get(key) + ";";
            }

            return s;
        }

        /**
         * Procesa pedidos que comienzan con "A"
         */
        void procesar() {

            // comparación redundante
            if (activo == true) {

                // for clásico
                for (int i = 0; i < pedidos.size(); i++) {

                    Object pedido = pedidos.get(i);

                    // chequeo manual de tipo
                    if (pedido instanceof String) {

                        String p = (String) pedido;

                        // filtramos pedidos tipo A
                        if (p.startsWith("A")) {

                            if (!historial.containsKey(p)) {

                                // uso innecesario de wrapper
                                historial.put(p, new Integer(1));

                            } else {

                                Integer valor = (Integer) historial.get(p);

                                historial.put(p,
                                        new Integer(valor.intValue() + 1));
                            }
                        }
                    }
                }

                // API antigua de fecha
                fechaUltimoProceso = new Date();
            }
        }
    }

    /**
     * IMPLEMENTACIÓN REFACTORIZADA
     *
     * Mejora el código usando:
     * - generics
     * - streams
     * - API moderna de fecha
     * - código más expresivo
     */
    static class PedidoProcessorRefactorizado {

        // Tipado seguro
        private final List<String> pedidos = new ArrayList<>();

        // Map tipado
        private final Map<String, Integer> historial = new HashMap<>();

        // API moderna de tiempo
        private Instant fechaUltimoProceso;

        // valor inicial
        private boolean activo = true;

        /**
         * Agrega pedido
         */
        public void agregarPedido(String p) {
            pedidos.add(p);
        }

        /**
         * Construye resumen usando Streams
         */
        public String getResumen() {

            return historial.entrySet()
                    .stream()
                    .map(e -> e.getKey() + ":" + e.getValue())
                    .collect(Collectors.joining(";"));
        }

        /**
         * Procesamiento usando Streams
         */
        void procesar() {

            // guard clause
            if (!activo) return;

            pedidos.stream()
                    .filter(p -> p.startsWith("A"))
                    .forEach(p -> historial.merge(p, 1, Integer::sum));

            fechaUltimoProceso = Instant.now();
        }
    }
}