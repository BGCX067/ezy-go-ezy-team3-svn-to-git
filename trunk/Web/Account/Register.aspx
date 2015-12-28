<%@ Page Title="Register" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true"
    CodeFile="Register.aspx.cs" Inherits="Account_Register" %>

<asp:Content ID="HeaderContent" runat="server" ContentPlaceHolderID="HeadContent">
</asp:Content>
<asp:Content ID="BodyContent" runat="server" ContentPlaceHolderID="MainContent">
    <asp:CreateUserWizard ID="RegisterUser" runat="server" EnableViewState="false" OnCreatedUser="RegisterUser_CreatedUser">
        <LayoutTemplate>
            <asp:PlaceHolder ID="wizardStepPlaceholder" runat="server"></asp:PlaceHolder>
            <asp:PlaceHolder ID="navigationPlaceholder" runat="server"></asp:PlaceHolder>
        </LayoutTemplate>
        <WizardSteps>
            <asp:CreateUserWizardStep ID="RegisterUserWizardStep" runat="server">
                <ContentTemplate>
                    <h2>
                        Create a New Account
                    </h2>
                    <p>
                        Use the form below to create a new account.
                    </p>
                    <p>
                        Password must be at least <%= Membership.MinRequiredPasswordLength %> characters.
                    </p>
                    <span class="failureNotification">
                        <asp:Literal ID="ErrorMessage" runat="server"></asp:Literal>
                    </span>
                    <asp:ValidationSummary ID="RegisterUserValidationSummary" runat="server" CssClass="failureNotification" 
                         ValidationGroup="RegisterUserValidationGroup"/>
                    <div class="accountInfo">
                        <fieldset class="register">
                            <legend>Account Information</legend>
                            <p>
                                <asp:Label ID="UserNameLabel" runat="server" AssociatedControlID="UserName">Username (NRIC/FIN/Passport No.):</asp:Label>
                                <asp:TextBox ID="UserName" runat="server" CssClass="textEntry"></asp:TextBox>
                                <asp:RequiredFieldValidator ID="UserNameRequired" runat="server" ControlToValidate="UserName" 
                                     CssClass="failureNotification" ErrorMessage="Please enter your Username." ToolTip="Please enter your Username." 
                                     ValidationGroup="RegisterUserValidationGroup">*</asp:RequiredFieldValidator>
                            </p>
                            <p>
                                <asp:Label ID="FullNameLabel" runat="server" AssociatedControlID="FullName">Full Name (as shown in NRIC/FIN/Passport No.):</asp:Label>
                                <asp:TextBox ID="FullName" runat="server" CssClass="textEntry"></asp:TextBox>
                                <asp:RequiredFieldValidator ID="FullNameRequired" runat="server" ControlToValidate="FullName" 
                                     CssClass="failureNotification" ErrorMessage="Please enter your Full Name." ToolTip="Please enter your Full Name." 
                                     ValidationGroup="RegisterUserValidationGroup">*</asp:RequiredFieldValidator>
                            </p>
                            <p>
                                <asp:Label ID="EmailLabel" runat="server" AssociatedControlID="Email">E-mail Address:</asp:Label>
                                <asp:TextBox ID="Email" runat="server" CssClass="textEntry"></asp:TextBox>
                                <asp:RequiredFieldValidator ID="EmailRequired" runat="server" ControlToValidate="Email" 
                                     CssClass="failureNotification" Display="Dynamic" ErrorMessage="Please enter your E-mail Address." ToolTip="Please enter your E-mail Address." 
                                     ValidationGroup="RegisterUserValidationGroup">*</asp:RequiredFieldValidator>
                                <asp:RegularExpressionValidator ID="EmailValidator" runat="server" ControlToValidate="Email"
                                     CssClass="failureNotification" Display="Dynamic" ErrorMessage="Please enter a valid E-mail Address."
                                     ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*"
                                     ValidationGroup="RegisterUserValidationGroup">*</asp:RegularExpressionValidator>
                            </p>
                             <p>
                                <asp:Label ID="MobileLabel" runat="server" AssociatedControlID="Mobile">Mobile No:</asp:Label>
                                <asp:TextBox ID="Mobile" runat="server" CssClass="textEntry"></asp:TextBox>
                                <asp:RequiredFieldValidator ID="MobileRequired" runat="server" ControlToValidate="Mobile" 
                                     CssClass="failureNotification" ErrorMessage="Please enter your Mobile No." ToolTip="Please enter your Mobile No." 
                                     ValidationGroup="RegisterUserValidationGroup">*</asp:RequiredFieldValidator>
                            </p>
                            <p>
                                <asp:Label ID="PasswordLabel" runat="server" AssociatedControlID="Password">Password:</asp:Label>
                                <asp:TextBox ID="Password" runat="server" CssClass="passwordEntry" TextMode="Password"></asp:TextBox>
                                <asp:RequiredFieldValidator ID="PasswordRequired" runat="server" ControlToValidate="Password" 
                                     CssClass="failureNotification" ErrorMessage="Please enter your Password." ToolTip="Please enter your Password." 
                                     ValidationGroup="RegisterUserValidationGroup">*</asp:RequiredFieldValidator>
                            </p>
                            <p>
                                <asp:Label ID="ConfirmPasswordLabel" runat="server" AssociatedControlID="ConfirmPassword">Confirm Password:</asp:Label>
                                <asp:TextBox ID="ConfirmPassword" runat="server" CssClass="passwordEntry" TextMode="Password"></asp:TextBox>
                                <asp:RequiredFieldValidator ControlToValidate="ConfirmPassword" CssClass="failureNotification" Display="Dynamic" 
                                     ErrorMessage="Please enter your Confirmation Password." ID="ConfirmPasswordRequired" runat="server" 
                                     ToolTip="Please enter your Confirmation Password." ValidationGroup="RegisterUserValidationGroup">*</asp:RequiredFieldValidator>
                                <asp:CompareValidator ID="PasswordCompare" runat="server" ControlToCompare="Password" ControlToValidate="ConfirmPassword" 
                                     CssClass="failureNotification" Display="Dynamic" ErrorMessage="Please ensure your Password and Confirmation Password are the same."
                                     ValidationGroup="RegisterUserValidationGroup">*</asp:CompareValidator>
                            </p>
                             <p>
                                <asp:Label ID="CreditCardLabel" runat="server" AssociatedControlID="CreditCard">Credit Card No:</asp:Label>
                                <asp:TextBox ID="CreditCard" runat="server" CssClass="textEntry"></asp:TextBox>
                                <asp:RequiredFieldValidator ID="CreditCardRequired" runat="server" ControlToValidate="CreditCard" 
                                     CssClass="failureNotification" ErrorMessage="Please enter your Credit Card No." ToolTip="Please enter your Credit Card No." 
                                     ValidationGroup="RegisterUserValidationGroup">*</asp:RequiredFieldValidator>
                            </p>
                            <p>
                                <asp:Label ID="CVCLabel" runat="server" AssociatedControlID="CVC">CVC No:</asp:Label>
                                <asp:TextBox ID="CVC" runat="server" CssClass="textEntry"></asp:TextBox>
                                <asp:RequiredFieldValidator ID="CVCRequired" runat="server" ControlToValidate="CVC" 
                                     CssClass="failureNotification" ErrorMessage="Please enter your CVC No." ToolTip="Please enter your CVC No." 
                                     ValidationGroup="RegisterUserValidationGroup">*</asp:RequiredFieldValidator>
                            </p>
                            <p>
                                <asp:Label ID="ExpiryDateLabel" runat="server" AssociatedControlID="ExpiryDate">Credit Card's Expiry Date (MM/YYYY):</asp:Label>
                                <asp:TextBox ID="ExpiryDate" runat="server" CssClass="textEntry"></asp:TextBox>
                                <asp:RequiredFieldValidator ID="ExpiryDateRequired" runat="server" ControlToValidate="ExpiryDate" 
                                     CssClass="failureNotification" ErrorMessage="Please enter your Credit Card's Expiry Date" ToolTip="Please enter your Credit Card's Expiry Date" 
                                     ValidationGroup="RegisterUserValidationGroup">*</asp:RequiredFieldValidator>
                            </p>
                             <p>
                                <asp:Label ID="PaymentLabel" runat="server" AssociatedControlID="Payment">Mode of Payment:</asp:Label>
                                 <asp:DropDownList ID="Payment" runat="server"> 
                                 <asp:ListItem Value="Please select your Payment mode"></asp:ListItem>
                                <asp:ListItem>Prepaid</asp:ListItem>
                                <asp:ListItem>Postpaid</asp:ListItem></asp:DropDownList>
                                <asp:RequiredFieldValidator ID="PaymentRequired" runat="server" ControlToValidate="Payment" 
                                     CssClass="failureNotification" ErrorMessage="Please select your Payment mode" ToolTip="Please select your Payment mode" 
                                     ValidationGroup="RegisterUserValidationGroup" InitialValue="Please select your Payment mode">*</asp:RequiredFieldValidator>
                            </p>

                        </fieldset>
                        <p class="submitButton">
                            <asp:Button ID="CreateUserButton" runat="server" CommandName="MoveNext" Text="Create User" 
                                 ValidationGroup="RegisterUserValidationGroup"/>
                        </p>
                    </div>
                </ContentTemplate>
                <CustomNavigationTemplate>
                </CustomNavigationTemplate>
            </asp:CreateUserWizardStep>
        </WizardSteps>
    </asp:CreateUserWizard>
</asp:Content>