package faithdroid

type FTextView struct {
	FBaseView
}

func textview(a *Activity) *FTextView {
	v := &FTextView{}
	v.vID = newToken()
	v.className = "TextView"
	v.ui = a.ui
	a.ui.NewView(v.className, v.vID)
	return v
}
func (v *FTextView) getVID() string {
	return v.vID
}
func (v *FTextView) setId(s string) *FTextView {
	idMap[s] = v
	return v
}
func getTextViewById(id string) *FTextView {
	if v, ok := idMap[id].(*FTextView); ok {
		return v
	}
	return nil
}

func (v *FTextView) size(w, h int) *FTextView {
	i := []int{w, h}
	v.ui.ViewSetAttr(v.vID, "Size", jsonArray(i))
	return v
}

func (v *FTextView) background(s string) *FTextView {
	v.FBaseView.background(s)
	return v
}
func (v *FTextView) backgroundColor(s string) *FTextView {
	v.FBaseView.backgroundColor(s)
	return v
}

func (v *FTextView) cachedBackground(s string) *FTextView {
	v.FBaseView.cachedBackground(s)
	return v
}
func (v *FTextView) onClick(f func()) *FTextView {
	fnID := newToken()
	eventHandlersMap[fnID] = func(string) {
		f()
	}
	v.ui.ViewSetAttr(v.vID, "OnClick", fnID)
	return v
}

func (v *FTextView) visible() *FTextView {
	v.FBaseView.visible()
	return v
}
func (v *FTextView) invisible() *FTextView {
	v.FBaseView.invisible()
	return v
}
func (v *FTextView) gone() *FTextView {
	v.FBaseView.gone()
	return v
}

func (v *FTextView) padding(left, top, right, bottom int) *FTextView {
	v.FBaseView.padding(left, top, right, bottom)
	return v
}
func (v *FTextView) paddingLeft(dp int) *FTextView {
	v.FBaseView.padding(dp, 0, 0, 0)
	return v
}
func (v *FTextView) paddingTop(dp int) *FTextView {
	v.FBaseView.padding(0, dp, 0, 0)
	return v
}
func (v *FTextView) paddingRight(dp int) *FTextView {
	v.FBaseView.padding(0, 0, dp, 0)
	return v
}
func (v *FTextView) paddingBottom(dp int) *FTextView {
	v.FBaseView.padding(0, 0, 0, dp)
	return v
}
func (v *FTextView) paddingAll(all int) *FTextView {
	v.FBaseView.padding(all, all, all, all)
	return v
}

func (v *FTextView) margin(left, top, right, bottom int) *FTextView {
	v.FBaseView.margin(left, top, right, bottom)
	return v
}
func (v *FTextView) marginLeft(dp int) *FTextView {
	v.FBaseView.margin(dp, 0, 0, 0)
	return v
}
func (v *FTextView) marginTop(dp int) *FTextView {
	v.FBaseView.margin(0, dp, 0, 0)
	return v
}
func (v *FTextView) marginRight(dp int) *FTextView {
	v.FBaseView.margin(0, 0, dp, 0)
	return v
}
func (v *FTextView) marginBottom(dp int) *FTextView {
	v.FBaseView.margin(0, 0, 0, dp)
	return v
}
func (v *FTextView) marginAll(dp int) *FTextView {
	v.FBaseView.margin(dp, dp, dp, dp)
	return v
}
func (v *FTextView) layoutGravity(gravity int) *FTextView {
	v.ui.ViewSetAttr(v.vID, "LayoutGravity", sPrintf("%v", gravity))
	return v
}

// --------------------------------------------------------
func (v *FTextView) text(s string) *FTextView {
	v.ui.ViewSetAttr(v.vID, "Text", s)
	return v
}

func (v *FTextView) textColor(s string) *FTextView {
	v.ui.ViewSetAttr(v.vID, "TextColor", s)
	return v
}

func (v *FTextView) textSize(dpsize int) *FTextView {
	v.ui.ViewSetAttr(v.vID, "TextSize", sPrintf("%v", dpsize))
	return v
}
func (v *FTextView) getText() string {
	return v.ui.ViewGetAttr(v.vID, "Text")
}
