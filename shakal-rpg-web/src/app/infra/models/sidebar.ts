
export interface SidebarItem{
    label:string,
    path: string,
    icon: string
}
export const sidebarItems: SidebarItem[] = [
    {
        label:"Histórias",
        path:'story',
        icon:'library_books'
    },{
        label:"Criaturas",
        path:"monster",
        icon:"mood_bad"
    }
]