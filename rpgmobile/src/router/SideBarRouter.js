import { createDrawerNavigator } from "react-navigation";
import StoryPage from '../pages/StoryPage'



const Sidebar = createDrawerNavigator({

    Story: StoryPage
    
})


export default Sidebar;