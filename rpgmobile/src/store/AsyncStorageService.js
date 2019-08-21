import AsyncStorage from "@react-native-community/async-storage";
import { USER_STORAGE } from "../reducers/UserReducer";

export async function saveUser (content) {
    try {
        await AsyncStorage.setItem(USER_STORAGE, JSON.stringify(content));
    } catch (error) {
        console.log(error)
    }
};
