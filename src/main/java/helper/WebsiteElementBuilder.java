package helper;
//<i class='material-symbols-outlined'>grocery</i>
public class WebsiteElementBuilder {
    //Returns extra APIs and elements, such as icons and fonts
    public String getExtraCSS() {
        String str = """            
            <link rel='icon' type='image/x-icon' href='./icons/logo.png' media="(prefers-color-scheme: dark)">
            <link rel='icon' type='image/x-icon' href='./icons/logo-dark.png' media="(prefers-color-scheme: light)">

            <link rel='preconnect' href='https://fonts.googleapis.com'>
            <link rel='preconnect' href='https://fonts.gstatic.com' crossorigin>

            <link href='https://fonts.googleapis.com/css2?family=Comfortaa:wght@300..700&display=swap' rel='stylesheet'>
            <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
            """;
            return str;
        }
    
    //Navigation properties update globally
    public String getNavBar() {
    String str = """
            <div class='topnav'>
                <ul>
                    <div class='nav-logo'>
                        <a href='/'>
                            <li><img src='./icons/logo.png' class='topnavimg'></li>
                            <li><h2>Food Waste Help</h2></li>
                        </a>
                    </div>
                    <div class='nav-links'>
                        <li><a href='mission.html'>Our Mission</a></li>
                        <li><a href='page2A.html'>Sub Task 2.A</a></li>
                        <li><a href='page2B.html'>Sub Task 2.B</a></li>
                        <li><a href='page3A.html'>Sub Task 3.A</a></li>
                        <li><a href='page3B.html'>Sub Task 3.B</a></li>
                    </div>
                </ul>
            </div>
        """; 
        return str;
    }

    //Footer properties update globally
    public String getFooter() {
        String str = """
            <div class='footer'>
                <ul>
                    <a href='/'>
                        <li><img src='./icons/logo.png' class='footerimg'></li>
                        <li><h2>Food Waste Help</h2></li>
                    </a>
                    <li><a href='mission.html'>Our Mission</a></li>
                </ul>
            </div>
        """;
        return str;
    }
}

