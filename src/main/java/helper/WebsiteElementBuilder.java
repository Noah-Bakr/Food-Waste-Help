package helper;
//<i class='material-symbols-outlined'>grocery</i>
public class WebsiteElementBuilder {
    //Navigation properties update globally
    public String getNavBar() {
    String str = """
            <div class='topnav'>
                <ul>
                    
                    <li>
                        <img src='./icons/logo.png' class='topnavimg'>
                    </li>
                    <li><h2>Food Waste Help</h2></li>
                    <li><a href='/'>Homepage</a></li>
                    <li><a href='mission.html'>Our Mission</a></li>
                    <li><a href='page2A.html'>Sub Task 2.A</a></li>
                    <li><a href='page2B.html'>Sub Task 2.B</a></li>
                    <li><a href='page3A.html'>Sub Task 3.A</a></li>
                    <li><a href='page3B.html'>Sub Task 3.B</a></li>
                </ul>
            </div>
        """; 
        return str;
    }

    //Returns extra APIs and elements, such as icons and fonts
    public String getExtraCSS() {
        String str = """
            <link rel='icon' type='image/x-icon' href='./icons/logo.png'>
            <link rel='stylesheet' href='https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0' />";
            <link rel='preconnect' href='https://fonts.googleapis.com'>";
            <link rel='preconnect' href='https://fonts.gstatic.com' crossorigin>";
            <link href='https://fonts.googleapis.com/css2?family=Comfortaa:wght@300..700&display=swap' rel='stylesheet'>
            """;
            return str;
        }
}