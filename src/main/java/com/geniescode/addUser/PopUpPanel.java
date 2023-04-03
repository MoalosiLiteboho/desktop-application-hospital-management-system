package com.geniescode.addUser;

import com.geniescode.authority.GetAuthorityList;
import com.geniescode.share.components.buttons.Button;
import com.geniescode.share.components.comboBox.ComboBox;
import com.geniescode.share.components.dateChooser.DateChooserField;
import com.geniescode.share.components.panel.Panel;
import com.geniescode.share.components.textField.TextField;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

public class PopUpPanel extends Panel {
    private ComboBox<String> authority;
    private final java.util.List<String> genderList = List.of("Male", "Female", "Others");
    private TextField name;
    private TextField surname;
    private DateChooserField dateOfBirth;
    private ComboBox<String> gender;
    private TextField email;
    private Button reset;
    private Button registration;

    public PopUpPanel() {
        initComponents();
    }

    private void initComponents() {
        JLabel tittle = new JLabel("Add User");
        name = new TextField("Name", Color.green);
        surname = new TextField("Surname", Color.green);
        authority = new ComboBox<>("Authority", Color.green);
        dateOfBirth = new DateChooserField("Date Of Birth (yyyy-mm-dd)", Color.green);
        gender = new ComboBox<>("Gender", Color.green);
        email = new TextField("Email", Color.green);
        reset = new Button("Reset");
        registration = new Button("Registration");

        gender.addModels(genderList);
        gender.setSelectedIndex(-1);

        authority.addModels(new GetAuthorityList().get());
        authority.setSelectedIndex(-1);

        tittle.setForeground(Color.green);
        tittle.setFont(tittle.getFont().deriveFont(Font.PLAIN, 25));
        tittle.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new MigLayout("inset 0, gap 0, wrap"));
        add(tittle, "width 100%, gap top 20px");
        add(authority, "width 60%, gap left 20%");
        add(name, "width 60%, gap left 20%, gap top 5px");
        add(surname, "width 60%, gap left 20%, gap top 5px");
        add(dateOfBirth, "width 60%, gap left 20%, gap top 5px");
        add(gender, "width 60%, gap left 20%");
        add(email, "width 60%, gap left 20%, gap top 5px");
        add(registration, "width 30%, height 35px, gap left 35%, gap top 20px");
        add(reset, "width 30%, height 35px, gap left 35%, gap top 6px");
        setFont(new Font("sanserif", Font.PLAIN, 15));
        setBackground(Color.white);
        setPreferredSize(new Dimension(700, 500));
    }
}
