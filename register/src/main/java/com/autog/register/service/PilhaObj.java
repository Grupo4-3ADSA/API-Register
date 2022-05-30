package com.autog.register.service;

public class PilhaObj<T> {

    private T[] pilha;
    private int topo;

    public PilhaObj(int capacidade) {
        pilha = (T[]) new Object[capacidade];
        topo = -1;
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == pilha.length - 1;
    }

    public void push(T info) {
        if (isFull()) {
            throw new IllegalStateException("Não cabe mais nada");
        }

        pilha[++topo] = info;
    }

    public T pop() {
        return isEmpty() ? null : pilha[topo--];
    }

    public T peek() {
        return isEmpty() ? null : pilha[topo];
    }

}
