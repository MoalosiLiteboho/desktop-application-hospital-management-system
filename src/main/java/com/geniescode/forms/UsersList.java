package com.geniescode.forms;

import com.geniescode.share.components.buttons.Button;
import com.geniescode.share.components.panel.Panel;
import com.geniescode.share.components.table.Table;
import com.geniescode.user.FindAllUsers;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.function.Consumer;

public class UsersList extends Panel {
    private Table userTable;
    private JScrollPane scrollPane;
    private Button addUserButton;

    public UsersList() {
        initComponents();
        initTable();
    }

    private void initTable() {
        userTable.fixTable(scrollPane);
        populateTable();
    }

    private void initComponents() {
        Panel tablePanel = new Panel();
        JLabel tittle = new JLabel("User Table");
        addUserButton = new Button("Add User");
        scrollPane = new JScrollPane();
        userTable = new Table();

        userTable.setModel(new DefaultTableModel(
                new Object [][] {},
                new String [] {"#", "Name", "Surname", "Gender", "Date Of Birth",  "Email", "Authority", "Action"}) {
            final boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        scrollPane.setViewportView(userTable);

        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scrollPane);
        tablePanel.setBottomLine(Color.green, new Color(0x4A00FF00, true));

        tittle.setHorizontalAlignment(SwingConstants.CENTER);
        tittle.setFont(tittle.getFont().deriveFont(Font.PLAIN, 25));
        tittle.setForeground(Color.green);

        setLayout(new MigLayout("inset 0, gap 0, wrap"));
        add(tittle, "width 100%, gap top 25px");
        add(addUserButton, "gap left 30px, gap top 25px, gap bottom 15px, width 150px, height 35px");
        add(tablePanel, "gap left  30px, gap right 30px, width 100%, gap top 35px, gap bottom 35px, height 100%");
        setBackground(Color.white);
        setFont(new Font("sanserif", Font.PLAIN, 15));
        addController.accept(this);
    }

    public void populateTable() {
        new FindAllUsers().get()
                .forEach(user -> userTable.addRow(new Object[] {user.id(), user.name(), user.surname(), user.gender(), user.dateOfBirth(), user.email(), user.authority()}));
    }

    public Button getAddUserButton() {
        return addUserButton;
    }

    public void addUserListController(UserListController controller) {
        addUserButton.addActionListener(controller);
    }

    private final Consumer<UsersList> addController = UserListController::new;
}
