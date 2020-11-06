import * as React from 'react';
import { FAB, Portal, Provider } from 'react-native-paper';
import Colors from '../../styles/ColorsStyle';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { setWalkPoperties,setActionProperties} from '../../actions/CombatAction';
import  CombatRoomService from '../../service/CombatRoomService';

const CombatPlayerMenu = (props) => {
  const [state, setState] = React.useState({ open: false });

  const onStateChange = ({ open }) => setState({ open });

  const { open } = state;
  const { combatStatus,playerId,setWalkPoperties,setActionProperties} = props;

  let handleSelectWalk =() =>{
    
    let player = props.combatStatus.creatures.find(creature => creature.id === props.playerId);
    props.setWalkPoperties({
        x:player.position.x,
        y:player.position.y,
        walkVisible:true,
        dashVisible:false
    });
  }
  let handleSelectDash =() =>{
    
    let player = props.combatStatus.creatures.find(creature => creature.id === props.playerId);
    props.setWalkPoperties({
        x:player.position.x,
        y:player.position.y,
        walkVisible:false,
        dashVisible:true
    });
  }
  let HandleEndTurn = () =>{
    props.setWalkPoperties({
      walkVisible:false,
      dashVisible:false
    });
    props.setActionProperties({
      walkMove: 0,
      dashMove: 0
    });
    CombatRoomService.passTurn(combatStatus);
  }

  return (
    <Provider>
      <Portal>
        <FAB.Group
          color={Colors.LIGHT_PRIMARY_COLOR}
          open={open}
          icon={open ? 'close' : 'star'}
          actions={[
            {
              icon: 'directions-walk',
              label: 'Andar',
            
              onPress: () => handleSelectWalk(),
            },
            {
              icon: 'directions-run',
              label: 'Desengajar',
              onPress: () => handleSelectDash(),
            },
            {
                icon: 'exit-to-app',
                label: 'Encerrar o turno',
                onPress: () => HandleEndTurn(),
              }
          ]}
          onStateChange={onStateChange}
          onPress={() => {
            if (open) {
              // do something if the speed dial is open
            }
          }}
        />
      </Portal>
    </Provider>
  );
};
const mapStateToProps = state => ({ 
    combatStatus: state.CombatReducer.combatState,
    playerId: state.CharacterReducer.currentCharacter.characterToken.id,
});
const mapDispatchToProps = dispatch => bindActionCreators({
    setWalkPoperties,
    setActionProperties
}, dispatch);
export default connect(mapStateToProps,mapDispatchToProps)(CombatPlayerMenu);

