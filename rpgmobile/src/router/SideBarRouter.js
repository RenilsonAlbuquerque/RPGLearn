import { createDrawerNavigator } from "react-navigation";
import StoryPage from '../components/story/storyPage'



const Sidebar = createDrawerNavigator({

    Story: StoryPage
    
})


export default Sidebar;