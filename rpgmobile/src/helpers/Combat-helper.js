export default function changeColor(percent){
    var result = ''; 
    if(percent == 0){
        result = 'black'
    }
    else{
        if(percent >= 90){
            result = '#4CAF50'
        }else{
            if(percent <= 10){
                result =  '#F44336'
            }else{
                result = '#FFEB3B'
            }
        }
    }
    
    
    return result;
}