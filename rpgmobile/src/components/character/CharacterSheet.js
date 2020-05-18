import { createAppContainer, createMaterialTopTabNavigator } from "react-navigation";
import SheetDatail from '../character/SheetDetail'
import Colors from "../../styles/ColorsStyle";
import StatusSheet from "./StatusSheet";
import SpellSheet from "./SpellSheet";

const MonsterSheetTopNavigator = createMaterialTopTabNavigator({
    StatusSheet: {screen: StatusSheet,navigationOptions: {tabBarLabel: 'Status'}},
    SheetDatail: {screen: SheetDatail,navigationOptions: {tabBarLabel: 'Detalhes'}},
    SpellSheet: {screen: SpellSheet,navigationOptions: {tabBarLabel: 'Magias'}}
},
{
    initialRouteName: 'StatusSheet',
    tabBarOptions: { 
        style:{
            backgroundColor: Colors.DARK_PRIMARY_COLOR 
        }
    }
});

export default createAppContainer(MonsterSheetTopNavigator);