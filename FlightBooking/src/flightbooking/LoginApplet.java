/*
 *      Author: Arzam Muzaffar Kotriwala
 *      Company: University of Nottingham Malaysia Campus
 *      Date of completion: 27th April 2014
 *      Version number: 1.0
 */

package flightbooking;
import java.awt.CardLayout;         // For card layout of 3 panels
import java.awt.HeadlessException;
import java.sql.*;                  // To execute SQL statements
import java.text.DecimalFormat;     // For precision of double numbers with decimals
import java.util.ArrayList;         // To use array list to display routes
import javax.swing.JOptionPane;     // To use dialog boxes
import net.proteanit.sql.DbUtils;   // For rs2xml library


public class LoginApplet extends javax.swing.JApplet {

    private static Connection con;
//    private static java.sql.Connection con;  // declare static since main class is static
    java.sql.Statement stmt;                // SQL Statement object (not the string)
    java.sql.ResultSet rs = null;               // To store the results of the SQL query
//    String url = "jdbc:odbc:flightBookingDB";	// where to find the DB (DSN)
    
    String url = "jdbc:ucanaccess:/Users/arzam/Desktop/Programming Projects/H63JAV - Web Based Computing/Java_Coursework/flightBookingDB.accdb";
    
    // To store user input for login screen
    String firstNameEntered = "";
    String lastNameEntered = "";
    String userNameEntered = "";
    String passwordEntered = "";
    String confirmPasswordEntered = "";
    String DOBEntered = "";
    char genderEntered;
    
    // To use the details of the logged in user
    String loggedInUserFirstName;
    String loggedInUserLastName;
    String loggedInUserID;
    
     // To store user input for flight search screen
    String originEntered;
    String destinationEntered;
    String departDateEntered = "";
    String arriveDateEntered = "";
    String travelTypeEntered;
    String cabinClassEntered;
    int adultSpinValue;
    int childSpinValue;
    int infantSpinValue;
    
    
    String[] checkOriginExists = new String[10];;
    String[] checkDestinationExists = new String[10];
    String[] originAirportName = new String[10];
    String[] destinationAirportName = new String[10];
    int originFlightOptions = 0;
    int destinationFlightOptions = 0;
    int finalFlightOptions = 0;
    String[] price = new String[10];
    
    User u = new User();    // Definition of a user for a particular session
                
    ArrayList<ArrayList<String>> routes = new ArrayList<>();        // To display routes in the final screen
 
    // Variables to calculate the total cost of flight
    String baseFare;
    String taxOnBaseFare;
    Boolean bookingConfirmed;       // To ensure a flight option is selected
    
    //StringBuilder SB = new StringBuilder();
    
    public LoginApplet() throws HeadlessException {
        
        try
        {
//            String driver = "sun.jdbc.odbc.JdbcOdbcDriver";     // Declaration of driver
//            Class.forName(driver).newInstance();                // To load driver
//            
//            con = DriverManager.getConnection(url);     // Connect to database
//            stmt = con.createStatement();               // Create a statement to access the table in database
            
            
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver";     // Declaration of driver
            Class.forName(driver).newInstance();                // To load driver
            System.out.println("Driver loaded");
            
            Connection con = DriverManager.getConnection(url);
            System.out.println("Database connected");
            
            Statement s = con.createStatement();
//            ResultSet rs = s.executeQuery("SELECT [LastName] FROM [Clients]");
//            while (rs.next()) {
//                System.out.println(rs.getString(1));
//            }
            
        }
        catch(Exception e)
        {
                JOptionPane.showMessageDialog(null, e);
        }
        
    }
       
    /**
     * Initializes the applet NewJApplet
     */
    @Override
    public void init() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the applet */
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                    
                    
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderButtonGroup = new javax.swing.ButtonGroup();
        travelButtonGroup = new javax.swing.ButtonGroup();
        basePanel = new javax.swing.JPanel();
        mainLoginPanel = new javax.swing.JPanel();
        signInPanel = new javax.swing.JPanel();
        registeredUserNameField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        registeredPasswordField = new javax.swing.JPasswordField();
        registrationPanel = new javax.swing.JPanel();
        lastNameField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        maleRadioButton = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        femaleRadioButton = new javax.swing.JRadioButton();
        unregisteredUserNameField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        DOBField = new com.toedter.calendar.JDateChooser();
        unregisteredPasswordField = new javax.swing.JPasswordField();
        unregisteredConfirmPasswordField = new javax.swing.JPasswordField();
        flightSearchPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        arriveDate = new com.toedter.calendar.JDateChooser();
        departDate = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cabinClassComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        originTextField = new javax.swing.JTextField();
        destinationTextField = new javax.swing.JTextField();
        findFlightsButton = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bookingType = new javax.swing.JLabel();
        returnRadioButton = new javax.swing.JRadioButton();
        oneWayRadioButton = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        infantSpinner = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        childSpinner = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        adultSpinner = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        flightBookingHistoryTable = new javax.swing.JTable();
        flightConfirmPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        chooseAFlightTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        paymentDetailsTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        basePanel.setLayout(new java.awt.CardLayout());

        mainLoginPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "easy-travel.com | Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 204))); // NOI18N

        signInPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Already a member? Sign in!", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Password:");

        loginButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("User Name:");

        javax.swing.GroupLayout signInPanelLayout = new javax.swing.GroupLayout(signInPanel);
        signInPanel.setLayout(signInPanelLayout);
        signInPanelLayout.setHorizontalGroup(
            signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signInPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registeredUserNameField)
                    .addComponent(registeredPasswordField))
                .addGap(18, 18, 18)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        signInPanelLayout.setVerticalGroup(
            signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signInPanelLayout.createSequentialGroup()
                .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signInPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(registeredUserNameField)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(registeredPasswordField)))
                    .addGroup(signInPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        registrationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Not a member? Register now!", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lastNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lastNameFieldFocusLost(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Password:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Last Name:");

        firstNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstNameFieldFocusLost(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Confirm Password:");

        registerButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("D.O.B:");

        genderButtonGroup.add(maleRadioButton);
        maleRadioButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        maleRadioButton.setText("Male");
        maleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioButtonActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("First Name:");

        genderButtonGroup.add(femaleRadioButton);
        femaleRadioButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        femaleRadioButton.setText("Female");
        femaleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioButtonActionPerformed(evt);
            }
        });

        unregisteredUserNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unregisteredUserNameFieldActionPerformed(evt);
            }
        });
        unregisteredUserNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                unregisteredUserNameFieldFocusGained(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("User Name:");

        DOBField.setMinSelectableDate(new java.util.Date(-62135794703000L));

        unregisteredPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                unregisteredPasswordFieldFocusGained(evt);
            }
        });

        javax.swing.GroupLayout registrationPanelLayout = new javax.swing.GroupLayout(registrationPanel);
        registrationPanel.setLayout(registrationPanelLayout);
        registrationPanelLayout.setHorizontalGroup(
            registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registrationPanelLayout.createSequentialGroup()
                .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, registrationPanelLayout.createSequentialGroup()
                        .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(registrationPanelLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registrationPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameField)
                            .addComponent(lastNameField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, registrationPanelLayout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(registrationPanelLayout.createSequentialGroup()
                        .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(registrationPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(registrationPanelLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registrationPanelLayout.createSequentialGroup()
                                .addComponent(DOBField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(maleRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(femaleRadioButton))
                            .addComponent(unregisteredPasswordField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(unregisteredUserNameField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(unregisteredConfirmPasswordField, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(30, 30, 30))
        );
        registrationPanelLayout.setVerticalGroup(
            registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DOBField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(femaleRadioButton)
                        .addComponent(maleRadioButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unregisteredUserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unregisteredPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unregisteredConfirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainLoginPanelLayout = new javax.swing.GroupLayout(mainLoginPanel);
        mainLoginPanel.setLayout(mainLoginPanelLayout);
        mainLoginPanelLayout.setHorizontalGroup(
            mainLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLoginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(signInPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registrationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(230, Short.MAX_VALUE))
        );
        mainLoginPanelLayout.setVerticalGroup(
            mainLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLoginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(signInPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registrationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        basePanel.add(mainLoginPanel, "mainLoginCard");

        flightSearchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "easy-travel.com | Flight Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 204))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder()));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Cabin Class");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Arriving Date");

        cabinClassComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Economy", "Business" }));
        cabinClassComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cabinClassComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Departing Date");

        originTextField.setText("City Name");
        originTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                originTextFieldActionPerformed(evt);
            }
        });

        destinationTextField.setText("City Name");

        findFlightsButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        findFlightsButton.setText("Find Flights");
        findFlightsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findFlightsButtonActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Origin");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Destination");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bookingType.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bookingType.setText("Type of Travel");

        travelButtonGroup.add(returnRadioButton);
        returnRadioButton.setSelected(true);
        returnRadioButton.setText("Return");
        returnRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnRadioButtonActionPerformed(evt);
            }
        });

        travelButtonGroup.add(oneWayRadioButton);
        oneWayRadioButton.setText("One-Way");
        oneWayRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneWayRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(returnRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(oneWayRadioButton)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bookingType, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(bookingType, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnRadioButton)
                    .addComponent(oneWayRadioButton))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Infants");

        infantSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel16.setText("<2 Yrs");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setText("2-11 Yrs");

        childSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Children");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel17.setText("12+ Yrs");

        adultSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Adults");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17)
                    .addComponent(adultSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(childSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infantSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(childSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(infantSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel1)
                            .addComponent(jLabel17)))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(adultSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(originTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(destinationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(arriveDate, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(departDate, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(cabinClassComboBox, 0, 120, Short.MAX_VALUE))))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(findFlightsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(originTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(destinationTextField))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(departDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(arriveDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cabinClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(findFlightsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Flight Search History", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        flightBookingHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Departure Date", "Departure", "Arrival", "Type of travel", "Cabin Class"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        flightBookingHistoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                flightBookingHistoryTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(flightBookingHistoryTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout flightSearchPanelLayout = new javax.swing.GroupLayout(flightSearchPanel);
        flightSearchPanel.setLayout(flightSearchPanelLayout);
        flightSearchPanelLayout.setHorizontalGroup(
            flightSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(flightSearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(flightSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        flightSearchPanelLayout.setVerticalGroup(
            flightSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(flightSearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        basePanel.add(flightSearchPanel, "flightSearchCard");

        flightConfirmPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "easy-travel.com | Confirm Booking ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 204))); // NOI18N

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Choose a flight", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        chooseAFlightTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Flight Option", "Departure Airport", "Arrival Airport", "Base Fare"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        chooseAFlightTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chooseAFlightTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(chooseAFlightTable);
        chooseAFlightTable.getColumnModel().getColumn(0).setHeaderValue("Flight Option");
        chooseAFlightTable.getColumnModel().getColumn(1).setHeaderValue("Departure Airport");
        chooseAFlightTable.getColumnModel().getColumn(2).setHeaderValue("Arrival Airport");
        chooseAFlightTable.getColumnModel().getColumn(3).setHeaderValue("Base Fare");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Your payment details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        paymentDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Base Fair", ""},
                {"Adults", null},
                {"Children", ""},
                {"Infants", null},
                {"Tax", null},
                {null, null},
                {"Total", null}
            },
            new String [] {
                "Fare Type", "Amount (RM)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(paymentDetailsTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Book flight");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout flightConfirmPanelLayout = new javax.swing.GroupLayout(flightConfirmPanel);
        flightConfirmPanel.setLayout(flightConfirmPanelLayout);
        flightConfirmPanelLayout.setHorizontalGroup(
            flightConfirmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(flightConfirmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(flightConfirmPanelLayout.createSequentialGroup()
                    .addComponent(jButton1)
                    .addGap(207, 207, 207)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(flightConfirmPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(flightConfirmPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        flightConfirmPanelLayout.setVerticalGroup(
            flightConfirmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, flightConfirmPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(flightConfirmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        basePanel.add(flightConfirmPanel, "flightConfirmCard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(basePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(basePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void maleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadioButtonActionPerformed
        genderEntered = maleRadioButton.getText().charAt(0);
    }//GEN-LAST:event_maleRadioButtonActionPerformed

    private void unregisteredUserNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unregisteredUserNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unregisteredUserNameFieldActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
       try{
            // To get user input for login screen
            firstNameEntered = firstNameField.getText();
            lastNameEntered = lastNameField.getText();
            userNameEntered = unregisteredUserNameField.getText();
            DOBEntered = DOBField.getDate().toString().substring(0, 10) + " " + DOBField.getDate().toString().substring(24, 28);

            // Password field returns character so need to convert to string
            char p1[] = unregisteredPasswordField.getPassword(); 
            passwordEntered = new String(p1);

            char p2[] = unregisteredConfirmPasswordField.getPassword(); 
            confirmPasswordEntered = new String(p2);
           
            if(passwordEntered.equals(confirmPasswordEntered))      // The two password fields must be the same
            {

                 try
                 {
                     //assign entered values to the user
                     u.setFirstName(firstNameEntered);
                     u.setLastName(lastNameEntered);
                     u.setUserName(userNameEntered);
                     u.setPassword(passwordEntered);
                     u.setDOB(DOBEntered);
                     u.setGender(genderEntered);

                     // Insert the user details into a table - registration of user
                     String sq = "INSERT INTO RegisteredUsers (FirstName,LastName,UserName,Password,DOB,Gender) VALUES ('"+u.getFirstName()+"','"+u.getLastName()+"','"+u.getUserName()+"','"+u.getPassword()+"','"+u.getDOB()+"','"+u.getGender()+"')";        
                     stmt = con.createStatement();
                     stmt.executeUpdate(sq);

                     JOptionPane.showMessageDialog(null, "Thank you for registering! You may sign in now.");

                     registeredUserNameField.setText(u.getUserName());

                     // Initialization of fields
                     firstNameField.setText("");
                     lastNameField.setText("");
                     unregisteredUserNameField.setText("");
                     DOBField.setDate(null);
                     unregisteredPasswordField.setText("");
                     unregisteredConfirmPasswordField.setText("");
                     genderButtonGroup.clearSelection();

                 }

              catch(Exception ex)
              {
                     JOptionPane.showMessageDialog(null, ex);

              }
          }
                else if (passwordEntered != confirmPasswordEntered)
                {
                    JOptionPane.showMessageDialog(null, "The password fields do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                }

          } 
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Please ensure all fields are completed.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_registerButtonActionPerformed

    // Focus lost = When the user leaves the field
    private void firstNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstNameFieldFocusLost
        firstNameEntered = firstNameField.getText();
        unregisteredUserNameField.setText(firstNameEntered.toLowerCase() + "_" + lastNameEntered.toLowerCase());
    }//GEN-LAST:event_firstNameFieldFocusLost

    private void lastNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameFieldFocusLost
        lastNameEntered = lastNameField.getText();
        unregisteredUserNameField.setText(firstNameEntered.toLowerCase() + "_" + lastNameEntered.toLowerCase());
    }//GEN-LAST:event_lastNameFieldFocusLost

    // Focus gained = When the user enters a field
    private void unregisteredUserNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_unregisteredUserNameFieldFocusGained
        DOBEntered = DOBField.getDate().toString().substring(0, 10) + " " + DOBField.getDate().toString().substring(24, 28);
        unregisteredUserNameField.setText(firstNameEntered.toLowerCase() + "_" + lastNameEntered.toLowerCase() + "_" + DOBEntered.substring(13));
    }//GEN-LAST:event_unregisteredUserNameFieldFocusGained

    private void unregisteredPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_unregisteredPasswordFieldFocusGained
        DOBEntered = DOBField.getDate().toString().substring(0, 10) + " " + DOBField.getDate().toString().substring(24, 28);
        unregisteredUserNameField.setText(firstNameEntered.toLowerCase() + "_" + lastNameEntered.toLowerCase() + "_" + DOBEntered.substring(13));
    }//GEN-LAST:event_unregisteredPasswordFieldFocusGained

    private void femaleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioButtonActionPerformed
        genderEntered = femaleRadioButton.getText().charAt(0);
    }//GEN-LAST:event_femaleRadioButtonActionPerformed

      
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        try
        {
            String login_userNameEntered = registeredUserNameField.getText().trim();
            String login_passwordEntered = registeredPasswordField.getText().trim();
 
            // Ensures that the user name and password match and exist in the resistered users table
            String sq = "SELECT * FROM RegisteredUsers WHERE UserName = '"+login_userNameEntered+"'AND Password = '"+login_passwordEntered+"'";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sq);    //The usernames and passwords that match are returned

            int counter = 0;
            while(rs.next())    // While records exist in the result set
            {
                counter++;      // To count number of such records
            }
            
            // Repeat of above statement to perform further operations
            String sq1 = "SELECT * FROM RegisteredUsers WHERE UserName = '"+login_userNameEntered+"'AND Password = '"+login_passwordEntered+"'";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sq1);    //The usernames and passwords that match are returned

            while(rs.next())    // While records exist in the result set
            {

                if(counter == 1)    // One and only one record
                {
                    loggedInUserFirstName = rs.getString("FirstName");
                    loggedInUserLastName = rs.getString("LastName");
                    loggedInUserID = rs.getString("ID");
                    
                    CardLayout cl = (CardLayout) (basePanel.getLayout());
                    cl.show(basePanel,"flightSearchCard");
                    
                    UpdateflightBookingHistoryTable();
                }

                else if(counter > 1)
                {
                    JOptionPane.showMessageDialog(null,"Duplication error encountered. Please try another user name and password.", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }

            }

            if(counter == 0)   // record does not exist
            {
                JOptionPane.showMessageDialog(null,"Incorrect details. Please check user name and password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }//GEN-LAST:event_loginButtonActionPerformed

    private void findFlightsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findFlightsButtonActionPerformed
      
        try
        {
                // To access user entered data
                originEntered = originTextField.getText();
                destinationEntered = destinationTextField.getText();
                departDateEntered = departDate.getDate().toString().substring(0, 10) + " " + departDate.getDate().toString().substring(24, 28);
                arriveDateEntered = arriveDate.getDate().toString().substring(0, 10) + " " + arriveDate.getDate().toString().substring(24, 28);
                cabinClassEntered = cabinClassComboBox.getSelectedItem().toString();
                adultSpinValue = (Integer) adultSpinner.getValue();
                childSpinValue = (Integer) childSpinner.getValue();
                infantSpinValue = (Integer) infantSpinner.getValue();
                
             // Store data entered by user for future easy data entry   
             String sq = "INSERT INTO UserHistory (ID,LastName,DepartureDate,Origin,Destination,TypeOfTravel,CabinClass,Adults,Children,Infants) VALUES ('"+loggedInUserID+"','"+loggedInUserLastName+"','"+departDateEntered+"','"+originEntered+"','"+destinationEntered+"','"+travelTypeEntered+"','"+cabinClassEntered+"','"+adultSpinValue+"','"+childSpinValue+"','"+infantSpinValue+"')";
             
             stmt = con.createStatement();
             stmt.executeUpdate(sq);
     
        try
        {
             // To get origin city
             String sq1 = "SELECT * FROM Airports WHERE CityName = '"+originEntered+"'";
             stmt = con.createStatement();
             rs = stmt.executeQuery(sq1);  
             
             while(rs.next()){
                 checkOriginExists[originFlightOptions] = rs.getString("IATA");
                 originAirportName[originFlightOptions] = rs.getString("AirportName");
                 
                 originFlightOptions++;
            }
        }
        catch (Exception ex)
        {
                 JOptionPane.showMessageDialog(null, ex);
        }
        try
        {
             // To get destination city
             String sq1 = "SELECT * FROM Airports WHERE CityName = '"+destinationEntered+"'";
             stmt = con.createStatement();
             rs = stmt.executeQuery(sq1); 
             
             while(rs.next()){
                checkDestinationExists[destinationFlightOptions] = rs.getString("IATA");
                destinationAirportName[destinationFlightOptions] = rs.getString("AirportName");
   
                destinationFlightOptions++;
             }
             
        }
        catch (Exception ex)
        {
                 JOptionPane.showMessageDialog(null, ex);
        }
 
        for(int i = 0; i < originFlightOptions; i++)
        {
            for(int j = 0; j < destinationFlightOptions; j++)
            {
                try
                {
                     String sq1 = "SELECT * FROM Routes WHERE Origin = '"+checkOriginExists[i]+"'AND Destination = '"+checkDestinationExists[j]+"'";
                     stmt = con.createStatement();
                     rs = stmt.executeQuery(sq1); 
                    
                    while(rs.next())    // While records exist in the result set
                    {

                       checkOriginExists[i] = rs.getString("Origin");
                       checkDestinationExists[j] = rs.getString("Destination");
                       price[j] = rs.getString("Price");
             
                       // This enables the display of the various possible routes on the final screen
                        ArrayList<String> temp  = new ArrayList<>();
                        temp.add(checkOriginExists[i]);
                        temp.add(checkDestinationExists[j]);
                        temp.add(price[j]);
                        routes.add(temp);
                        finalFlightOptions++; 
                      
                    }

                }
                catch (Exception ex)
                {
                         JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
        
        CardLayout cl = (CardLayout) (basePanel.getLayout());
                    cl.show(basePanel,"flightConfirmCard");     // Switches to next screen/card
                    UpdatechooseAFlightTable();
                    
                     }
      
        catch (Exception ex)
        {
             JOptionPane.showMessageDialog(null, ex);
                 //JOptionPane.showMessageDialog(null, "Please ensure all fields are completed.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_findFlightsButtonActionPerformed

    private void returnRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnRadioButtonActionPerformed
        travelTypeEntered = returnRadioButton.getText();
    }//GEN-LAST:event_returnRadioButtonActionPerformed

    private void oneWayRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneWayRadioButtonActionPerformed
        travelTypeEntered = oneWayRadioButton.getText();
    }//GEN-LAST:event_oneWayRadioButtonActionPerformed

    private void cabinClassComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cabinClassComboBoxActionPerformed
        cabinClassEntered = cabinClassComboBox.getSelectedItem().toString();
    }//GEN-LAST:event_cabinClassComboBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CardLayout cl = (CardLayout) (basePanel.getLayout());
        cl.show(basePanel,"flightSearchCard");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void flightBookingHistoryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flightBookingHistoryTableMouseClicked
        // Enters data into the table
        int row = flightBookingHistoryTable.getSelectedRow();
        originTextField.setText(flightBookingHistoryTable.getModel().getValueAt(row, 1).toString());
        destinationTextField.setText(flightBookingHistoryTable.getModel().getValueAt(row, 2).toString());
        
        travelTypeEntered = flightBookingHistoryTable.getModel().getValueAt(row, 3).toString();
        
        if(travelTypeEntered.equals("Return")){
            returnRadioButton.doClick();
        }
        else if(travelTypeEntered.equals( "One-Way")){
            oneWayRadioButton.doClick();
        }
               
        cabinClassComboBox.setSelectedItem(flightBookingHistoryTable.getModel().getValueAt(row, 4).toString());
    }//GEN-LAST:event_flightBookingHistoryTableMouseClicked

    private void chooseAFlightTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooseAFlightTableMouseClicked
        bookingConfirmed = true;
        
        int row = chooseAFlightTable.getSelectedRow();
        Double adultTotal = 0.0;
        Double childTotal = 0.0;
        Double infantTotal = 0.0;
        Double total = 0.0;
        
        // To calculate the total cost of flight
        baseFare = chooseAFlightTable.getModel().getValueAt(row, 3).toString();
        DecimalFormat df = new DecimalFormat("#.00"); 
        double baseFareDouble = Double.parseDouble(baseFare);
        double tax = baseFareDouble*0.1;
        
            adultTotal =  (baseFareDouble*adultSpinValue);
       
            childTotal = (baseFareDouble*childSpinValue*0.7);
        
            infantTotal = (baseFareDouble*infantSpinValue*0.3);
        
        
        total = adultTotal + childTotal + infantTotal + tax;
        
        taxOnBaseFare = Double.toString(tax);
          
        // Assigning to final table       
        paymentDetailsTable.setValueAt(baseFare, 0, 1);
        paymentDetailsTable.setValueAt(adultSpinValue, 1, 1);
        paymentDetailsTable.setValueAt(childSpinValue, 2, 1);
        paymentDetailsTable.setValueAt(infantSpinValue, 3, 1);
        paymentDetailsTable.setValueAt(taxOnBaseFare, 4, 1);
        paymentDetailsTable.setValueAt(total, 6, 1);
        
    }//GEN-LAST:event_chooseAFlightTableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{   
            if (bookingConfirmed == true)
            {
                // Display end message and log out
                JOptionPane.showMessageDialog(null, "Congratulations! Your flight has been booked. The system will now log out.");
                registeredUserNameField.setText("");
                registeredPasswordField.setText("");
                CardLayout cl = (CardLayout) (basePanel.getLayout());
                cl.show(basePanel,"mainLoginCard");     // Brings back to main screen
            }
        
        } 
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Please choose your flight details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void originTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_originTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_originTextFieldActionPerformed
    
    private void UpdateflightBookingHistoryTable(){
        
        try
        {
            String sq = "SELECT DepartureDate, Origin, Destination, TypeOfTravel, CabinClass FROM UserHistory WHERE ID = '"+loggedInUserID+"'";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sq);
            flightBookingHistoryTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
        
        private void UpdatechooseAFlightTable(){
        
        System.out.print(finalFlightOptions);
        for (int row =0; row < finalFlightOptions; row++){
                
                
                chooseAFlightTable.setValueAt(row,row,0);
                chooseAFlightTable.setValueAt(routes.get(row).get(0),row,1);
                chooseAFlightTable.setValueAt(routes.get(row).get(1),row,2);
                chooseAFlightTable.setValueAt(routes.get(row).get(2),row,3);
        }
    }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DOBField;
    private javax.swing.JSpinner adultSpinner;
    private com.toedter.calendar.JDateChooser arriveDate;
    private javax.swing.JPanel basePanel;
    private javax.swing.JLabel bookingType;
    private javax.swing.JComboBox cabinClassComboBox;
    private javax.swing.JSpinner childSpinner;
    private javax.swing.JTable chooseAFlightTable;
    private com.toedter.calendar.JDateChooser departDate;
    private javax.swing.JTextField destinationTextField;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.JButton findFlightsButton;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JTable flightBookingHistoryTable;
    private javax.swing.JPanel flightConfirmPanel;
    private javax.swing.JPanel flightSearchPanel;
    private javax.swing.ButtonGroup genderButtonGroup;
    private javax.swing.JSpinner infantSpinner;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel mainLoginPanel;
    private javax.swing.JRadioButton maleRadioButton;
    private javax.swing.JRadioButton oneWayRadioButton;
    private javax.swing.JTextField originTextField;
    private javax.swing.JTable paymentDetailsTable;
    private javax.swing.JButton registerButton;
    private javax.swing.JPasswordField registeredPasswordField;
    private javax.swing.JTextField registeredUserNameField;
    private javax.swing.JPanel registrationPanel;
    private javax.swing.JRadioButton returnRadioButton;
    private javax.swing.JPanel signInPanel;
    private javax.swing.ButtonGroup travelButtonGroup;
    private javax.swing.JPasswordField unregisteredConfirmPasswordField;
    private javax.swing.JPasswordField unregisteredPasswordField;
    private javax.swing.JTextField unregisteredUserNameField;
    // End of variables declaration//GEN-END:variables
}
