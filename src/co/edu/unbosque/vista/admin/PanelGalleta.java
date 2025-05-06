package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

public class PanelGalleta extends JPanel {

    private JRadioButton conChispas;
    private JRadioButton sinChispas;
    private ButtonGroup grupoChispas;

    public PanelGalleta() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBorder(BorderFactory.createTitledBorder("Atributos específicos de la Galleta"));

        conChispas = new JRadioButton("Con chispas");
        sinChispas = new JRadioButton("Sin chispas");

        grupoChispas = new ButtonGroup();
        grupoChispas.add(conChispas);
        grupoChispas.add(sinChispas);

        add(conChispas);
        add(sinChispas);
    }

    public boolean isConChispas() {
        return conChispas.isSelected();
    }

    public void setConChispas(boolean valor) {
        if (valor) {
            conChispas.setSelected(true);
        } else {
            sinChispas.setSelected(true);
        }
    }

    public void limpiar() {
        grupoChispas.clearSelection();
    }
    
    
}
