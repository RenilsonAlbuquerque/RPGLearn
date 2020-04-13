
export interface SidebarItem{
    label:string,
    path: string,
    icon: string
}
export const sidebarItems: SidebarItem[] = [
    {
        label:"Histórias",
        path:'story',
        icon:'running'
    },{
        label:"Criaturas",
        path:"monster",
        icon:"monster"
    }
]