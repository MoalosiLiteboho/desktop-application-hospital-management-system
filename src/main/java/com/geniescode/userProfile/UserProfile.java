package com.geniescode.userProfile;

import com.geniescode.share.components.buttons.Button;
import com.geniescode.share.components.comboBox.ComboBox;
import com.geniescode.share.components.dateChooser.DateChooserField;
import com.geniescode.share.components.panel.Panel;
import com.geniescode.share.components.textField.TextField;
import com.geniescode.user.GetUserById;
import com.geniescode.user.User;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class UserProfile extends Panel {
    private final int userId;
    private User user;
    private final List<String> genderList = List.of("Male", "Female", "Others");
    private TextField name;
    private TextField surname;
    private DateChooserField dateOfBirth;
    private ComboBox<String> gender;
    private TextField email;
    private com.geniescode.share.components.buttons.Button restoreButton;
    private Button savaChangesButton;

    public UserProfile() {
        userId = 3185922;
        initComponents();
        restoreFields();
    }

    private void initComponents() {
        JLabel tittle = new JLabel("My Profile");
        surname = new TextField("Surname", Color.green);
        name = new TextField("Name", Color.green);
        dateOfBirth = new DateChooserField("Date Of Birth (yyyy-mm-dd)", Color.green);
        gender = new ComboBox<>("Gender", Color.green);
        email = new TextField("Email", Color.green);
        restoreButton = new Button("Restore");
        savaChangesButton = new Button("Save Changes");

        gender.addModels(genderList);
        gender.setSelectedItem(user.gender());

        tittle.setForeground(Color.green);
        tittle.setFont(tittle.getFont().deriveFont(Font.PLAIN, 25));
        tittle.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new MigLayout("inset 0, gap 0, wrap"));
        add(tittle, "width 100%, gap top 20px");
        add(name, "width 60%, gap left 20%, gap top 20px");
        add(surname, "width 60%, gap left 20%, gap top 10px");
        add(dateOfBirth, "width 60%, gap left 20%, gap top 10px");
        add(gender, "width 60%, gap left 20%, gap top 10px");
        add(email, "width 60%, gap left 20%, gap top 5px");
        add(savaChangesButton, "width 30%, height 35px, gap left 35%, gap top 20px");
        add(restoreButton, "width 30%, height 35px, gap left 35%, gap top 6px");
        setFont(new Font("sanserif", Font.PLAIN, 15));
        setBackground(Color.white);
        addController.accept(this);
    }

    public String getAuthority() {
        return user.authority();
    }

    public String getName() {
        return name.getText();
    }

    public String getSurname() {
        return surname.getText();
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth.getText().equals("") ?
                LocalDate.now() : LocalDate.parse(dateOfBirth.getText());
    }

    public String getGender() {
        return gender.getSelectedIndex() != -1 || gender.getSelectedItem() != null?
                Objects.requireNonNull(gender.getSelectedItem())
                        .toString() : null;
    }

    public String getEmail() {
        return email.getText();
    }

    public Button getRestoreButton() {
        return restoreButton;
    }

    public Button getSavaChangesButton() {
        return savaChangesButton;
    }

    public void setUserById() {
        user = new GetUserById().apply(userId);
    }

    public void restoreFields() {
        setUserById();
        this.email.setText(user.email());
        this.gender.setSelectedItem(user.gender());
        this.dateOfBirth.setText(user.dateOfBirth().toString());
        this.surname.setText(user.surname());
        this.name.setText(user.name());
    }

    public void addButtonListener(UserProfileController controller) {
        restoreButton.addActionListener(controller);
        savaChangesButton.addActionListener(controller);
    }

    private final Consumer<UserProfile> addController = UserProfileController::new;
}
