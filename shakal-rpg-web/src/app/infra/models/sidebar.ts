
export interface SidebarItem{
    label:string,
    path?: string,
    icon?: string,
    children?:SidebarItem[]
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
    },{
        label:"Itens",
        children: [
            {
                label: "Armas",
                path:"/item/weapon/list",
                icon:'sword'
            }
        ]
    }
]