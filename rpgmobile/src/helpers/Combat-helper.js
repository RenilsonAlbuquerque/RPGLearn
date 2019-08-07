export default function changeColor(percent){
    var result = ''; 
    if(percent == 0){
        result = 'black'
    }
    else{
        if(percent >= 90){
            result = 'green'
        }else{
            if(percent <= 10){
                result =  'red'
            }else{
                result = 'yellow'
            }
        }
    }
    
    
    return result;
}