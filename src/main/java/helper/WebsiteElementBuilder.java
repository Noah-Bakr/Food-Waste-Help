package helper;

public class WebsiteElementBuilder {
    //Navigation properties update globally
    public String getNavBar() {
    String str = """
            <div class='topnav'>
                <ul>
                    <li class='logo'>
                    <img src='./icons/logo.png' alt='Food Waste Help Logo'>
                    <span class="material-symbols-outlined">
                    grocery
                    </span>
                    <h2>Food Waste Help</h2>
                    </li>
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
}