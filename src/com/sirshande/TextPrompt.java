package com.sirshande;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class TextPrompt extends JLabel implements FocusListener, DocumentListener {
    private static final long serialVersionUID = 1L;

    public enum Show {
        SIEMPRE, ENFOQUE_OBTENIDO, ENFOQUE_PERDIDO;
    }

    private JTextComponent componente;
    private Document documento;

    private Show show;
    private boolean mostrarIndicacionUnaVez;
    private int enfoquePerdido;

    public TextPrompt(String texto, JTextComponent componente) {
        this(texto, componente, Show.SIEMPRE);
    }

    public TextPrompt(String texto, JTextComponent componente, Show show) {
        this.componente = componente;
        setShow(show);
        documento = componente.getDocument();

        setText(texto);
        setFont(componente.getFont());

        setForeground(Color.gray);

        setHorizontalAlignment(JLabel.LEADING);

        componente.addFocusListener(this);
        documento.addDocumentListener(this);

        componente.setLayout(new BorderLayout());
        componente.add(this);
        checkForPrompt();
    }

    public void cambiarAlfa(float alpha) {
        cambiarAlfa((int) (alpha * 255));
    }

    public void cambiarAlfa(int alpha) {
        alpha = alpha > 255 ? 255 : alpha < 0 ? 0 : alpha;

        Color foreground = getForeground();
        int red = foreground.getRed();
        int green = foreground.getGreen();
        int blue = foreground.getBlue();

        Color conAlfa = new Color(red, green, blue, alpha);
        super.setForeground(conAlfa);
    }

    public void cambiarEstilo(int estilo) {
        setFont(getFont().deriveFont(estilo));
    }

    public Show obtenerShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public boolean obtenerShowPromptOnce() {
        return mostrarIndicacionUnaVez;
    }

    public void setShowPromptOnce(boolean mostrarIndicacionUnaVez) {
        this.mostrarIndicacionUnaVez = mostrarIndicacionUnaVez;
    }

    private void checkForPrompt() {
        if (documento.getLength() > 0) {
            setVisible(false);
            return;
        }

        if (mostrarIndicacionUnaVez && enfoquePerdido > 0) {
            setVisible(false);
            return;
        }

        if (componente.hasFocus()) {
            if (show == Show.SIEMPRE || show == Show.ENFOQUE_OBTENIDO)
                setVisible(true);
            else
                setVisible(false);
        } else {
            if (show == Show.SIEMPRE || show == Show.ENFOQUE_PERDIDO)
                setVisible(true);
            else
                setVisible(false);
        }
    }

    public void focusGained(FocusEvent e) {
        checkForPrompt();
    }

    public void focusLost(FocusEvent e) {
        enfoquePerdido++;
        checkForPrompt();
    }

    public void insertUpdate(DocumentEvent e) {
        checkForPrompt();
    }

    public void removeUpdate(DocumentEvent e) {
        checkForPrompt();
    }

    public void changedUpdate(DocumentEvent e) {
    }
}